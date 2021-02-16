package fr.alasdiablo.janoeo.world.gen;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.config.FrequencyConfig;
import fr.alasdiablo.janoeo.config.GlobalConfig;
import fr.alasdiablo.janoeo.config.ores.SandConfig;
import fr.alasdiablo.janoeo.init.ores.Sand;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.world.util.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Map;

public class OreGenerator implements IWorldGenerator {
    /**
     * @param biome Biome which receives the ConfiguredFeature
     * @see fr.alasdiablo.diolib.world.IWorldGenerator
     */
    @Override
    public void startWorldGeneration(Biome biome, Map<String, ForgeConfigSpec.BooleanValue> configOptions, Map<String, OreBlockProperties> ores, Map<String, OreBlockProperties> oresDense, String frequencyType, String prefix) {
        final GlobalConfig.Config GLOBAL_CONFIG = GlobalConfig.CONFIG;
        final FrequencyConfig.Config FREQUENCY_CONFIG = FrequencyConfig.CONFIG;

        if (GLOBAL_CONFIG.EXTRA_ORE_GEN.get() && ores != null) {
            for (Map.Entry<String, OreBlockProperties> ORE : ores.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET ORE BLOCK
                Block oreBlock = ORE.getValue().getBlock();

                // CHECK IF ORE IS ENABLED IN CONFIG
                if (configOptions.get(oreName).get()) {
                    // CHECK IF ORE ORE HAS FREQUENCY AND EXISTS FOR FREQUENCY TYPE
                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.containsKey(oreName) && FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).containsKey(frequencyType)) {
                        // ADD ORE TO WORLD GENERATION
                        WorldGenerationHelper.addFeature(
                                biome,
                                WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(oreBlock.getRegistryName()),
                                GenerationStage.Decoration.UNDERGROUND_ORES
                        );
                    }
                }
            }
        }

        // DISABLE NO DENSE SAND ORE
        if (GLOBAL_CONFIG.DENSE_ORE_GEN.get() && oresDense != null) {
            for (Map.Entry<String, OreBlockProperties> ORE : oresDense.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET ORE BLOCK
                Block oreBlock = ORE.getValue().getBlock();

                // CHECK IF ORE IS ENABLED IN CONFIG
                if (configOptions.get("DENSE_" + oreName).get()) {
                    // CHECK IF ORE ORE HAS FREQUENCY AND EXISTS FOR FREQUENCY TYPE
                    if (FREQUENCY_CONFIG.ORE_FREQUENCY.containsKey(oreName) && FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).containsKey(frequencyType + ".DENSE")) {
                        // CHECK IF ORE HAS MULTIPLIER FACTOR
                        if (FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType + ".DENSE").containsKey("FACTOR")) {
                            for (int i = 0; i < FREQUENCY_CONFIG.ORE_FREQUENCY.get(oreName).get(frequencyType + ".DENSE").get("FACTOR").get(); i++) {
                                WorldGenerationHelper.addFeature(
                                        biome,
                                        WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(
                                                RegistryHelper.setPrefixOnRegistryName(oreBlock.getRegistryName(), String.valueOf(i))
                                        ),
                                        GenerationStage.Decoration.UNDERGROUND_ORES
                                );
                            }
                        }
                    }
                }
            }
        }
    }

}
