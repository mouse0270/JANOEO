package fr.alasdiablo.janoeo.world.gen.feature;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.ExtenedFillerBlockType;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.init.*;
import fr.alasdiablo.janoeo.config.FrequencyConfig;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;

import java.util.Map;
import java.util.Objects;

/**
 * OreFeature Handler
 */
public class OresFeatures {

    /**
     * Instance of Frequency config
     */
    private static final FrequencyConfig.Config FREQUENCY_CONFIG = FrequencyConfig.CONFIG;

    public static <T> T getValueOrDefault(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    /**
     * Initialized Ore Features
     */
    public static void initOre(Map<String, OreBlockProperties> ORES, String frequencyType) {
        for (Map.Entry<String, OreBlockProperties> ORE : ORES.entrySet()) {
            // GET ORE KEY NAME
            String oreName = ORE.getKey();
            // GET ORE BLOCK
            Block oreBlock = ORE.getValue().getBlock();
            // GET ORE RULETEST
            RuleTest oreRuleTest = ORE.getValue().getRuleTest();
            // GET ORE BLOCKSTATE
            BlockState oreBlockState = getValueOrDefault(ORE.getValue().getBlockState(), oreBlock.getDefaultState());
            // DEFINE FREQUENCY VARIABLES
            int frequencySize = FREQUENCY_CONFIG.sizeAverage,
                frequencyCount = FREQUENCY_CONFIG.countAverage,
                frequencyBottom = FREQUENCY_CONFIG.worldMin,
                frequencyTop = FREQUENCY_CONFIG.worldAverage;

            if (FREQUENCY_CONFIG.ORE_FREQUENCY.containsKey(oreName)) {
                // SET FREQUENCY SIZE
                if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).containsKey(frequencyType)) {
                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("SIZE"))
                        frequencySize = getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("SIZE").get(), FREQUENCY_CONFIG.sizeAverage);

                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("COUNT"))
                        frequencyCount = getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("COUNT").get(), FREQUENCY_CONFIG.countAverage);

                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("BOTTOM"))
                        frequencyBottom = getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("BOTTOM").get(), FREQUENCY_CONFIG.worldMin);

                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("TOP"))
                        frequencyTop = getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("TOP").get(), FREQUENCY_CONFIG.worldAverage);
                }else{
                    Janoeo.logger.debug("Ore Feature: Useing averages to Register Feature for " + oreName + ". FREQUENCY TYPE NOT FOUND");
                }

                if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("FACTOR")) {
                    // DENSE ORE
                    Janoeo.logger.debug("Ore Feature: Registering " + oreName + ". DENSE ORE!");
                    for (int i = 0; i < FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("FACTOR").get(); i++) {
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                                Objects.requireNonNull(RegistryHelper.setPrefixOnRegistryName(oreBlock.getRegistryName(), String.valueOf(i))),
                                oreBlockState,
                                oreBlock.getDefaultState(),
                                frequencyCount, frequencyBottom, frequencyTop
                        );
                    }
                }else {
                    Janoeo.logger.debug("Ore Feature: Registering " + oreName + ". NORMAL ORE!");
                    if (oreRuleTest != null) {
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerOreFeature(
                                Objects.requireNonNull(oreBlock.getRegistryName()),
                                oreRuleTest,
                                oreBlock.getDefaultState(),
                                frequencySize, frequencyCount, frequencyBottom, frequencyTop
                        );
                    } else {
                        Janoeo.logger.debug("Ore Feature: RegisterReplaceBlockFeature");
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                                Objects.requireNonNull(oreBlock.getRegistryName()),
                                oreBlockState,
                                oreBlock.getDefaultState(),
                                frequencyCount, frequencyBottom, frequencyTop
                        );
                    }
                }
            }else{
                if (!FREQUENCY_CONFIG.ORE_FREQUENCY.containsKey(oreName)){
                    Janoeo.logger.debug("Ore Feature: Unable to Register Feature for " + oreName + ". FREQUENCY NOT FOUND");
                }else {
                    Janoeo.logger.debug("Ore Feature: Unable to Register Feature for " + oreName + ". FREQUENCY TYPE NOT FOUND");
                }
            }
        }
    }

}
