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

            if (FREQUENCY_CONFIG.ORE_FREQUENCY.containsKey(oreName) && FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).containsKey(frequencyType)) {
                Janoeo.logger.debug("Ore Feature: Registering " + oreName + ".");
                if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).containsKey("FACTOR")) {
                    // DENSE ORE
                    Janoeo.logger.debug("Ore Feature: Registering " + oreName + ". DENSE ORE!");
                    for (int i = 0; i < FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("FACTOR").get(); i++) {
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                                Objects.requireNonNull(RegistryHelper.setPrefixOnRegistryName(oreBlock.getRegistryName(), String.valueOf(i))),
                                oreBlockState,
                                oreBlock.getDefaultState(),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("COUNT").get(), FREQUENCY_CONFIG.countMax),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("BOTTOM").get(), FREQUENCY_CONFIG.worldMin),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("TOP").get(), FREQUENCY_CONFIG.worldMax)
                        );
                    }
                }else {
                    Janoeo.logger.debug("Ore Feature: Registering " + oreName + ". NORMAL ORE!");
                    if (oreRuleTest != null) {
                        Janoeo.logger.debug("Ore Feature: RegisterOreFeature");
                        Janoeo.logger.debug(oreRuleTest + " " + oreBlock.getDefaultState());
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerOreFeature(
                                Objects.requireNonNull(oreBlock.getRegistryName()),
                                oreRuleTest,
                                oreBlock.getDefaultState(),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("SIZE").get(), FREQUENCY_CONFIG.sizeAverage),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("COUNT").get(), FREQUENCY_CONFIG.countAverage),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("BOTTOM").get(), FREQUENCY_CONFIG.worldMin),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("TOP").get(), FREQUENCY_CONFIG.worldMax)
                        );
                    } else {
                        Janoeo.logger.debug("Ore Feature: RegisterReplaceBlockFeature");
                        WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                                Objects.requireNonNull(oreBlock.getRegistryName()),
                                oreBlockState,
                                oreBlock.getDefaultState(),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("COUNT").get(), FREQUENCY_CONFIG.countAverage),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("BOTTOM").get(), FREQUENCY_CONFIG.worldMin),
                                getValueOrDefault(FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType).get("TOP").get(), FREQUENCY_CONFIG.worldMax)
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

        /*
        WorldGenerationHelper.ConfiguredFeatureHelper.registerOreFeature(
                Objects.requireNonNull(
                        OverworldOresBlocks.COPPER_ORE.getRegistryName()
                ),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                OverworldOresBlocks.COPPER_ORE.getDefaultState(),
                FREQUENCY_CONFIG.COPPER_ORE_SIZE.get(),
                FREQUENCY_CONFIG.COPPER_ORE_COUNT.get(),
                FREQUENCY_CONFIG.COPPER_ORE_BOTTOM.get(),
                FREQUENCY_CONFIG.COPPER_ORE_TOP.get()
        );


        WorldGenerationHelper.ConfiguredFeatureHelper.registerReplaceBlockFeature(
                Objects.requireNonNull(
                        NetherOresBlocks.EMERALD_NETHER_ORE.getRegistryName()
                ),
                Blocks.NETHERRACK.getDefaultState(),
                NetherOresBlocks.EMERALD_NETHER_ORE.getDefaultState(),
                FREQUENCY_CONFIG.EMERALD_NETHER_ORE_COUNT.get(),
                FREQUENCY_CONFIG.EMERALD_NETHER_ORE_BOTTOM.get(),
                FREQUENCY_CONFIG.EMERALD_NETHER_ORE_TOP.get()
        );
        */
    }

}
