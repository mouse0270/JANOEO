package fr.alasdiablo.janoeo.world.gen;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.world.util.IWorldGenerator;
import fr.alasdiablo.diolib.world.WorldGenerationHelper;
import fr.alasdiablo.janoeo.config.FrequencyConfig;
import fr.alasdiablo.janoeo.config.GlobalConfig;
import fr.alasdiablo.janoeo.config.ores.StoneConfig;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

import java.util.Map;

public class StoneOreGenerator implements IWorldGenerator {
    /**
     * @param biome Biome which receives the ConfiguredFeature
     * @see fr.alasdiablo.diolib.world.IWorldGenerator
     */
    @Override
    public void startWorldGeneration(Biome biome, String frequencyType, String prefix) {
        final GlobalConfig.Config GLOBAL_CONFIG = GlobalConfig.CONFIG;
        final StoneConfig.Config STONE_CONFIG = StoneConfig.CONFIG;
        final FrequencyConfig.Config FREQUENCY_CONFIG = FrequencyConfig.CONFIG;

        if (GLOBAL_CONFIG.EXTRA_ORE_GEN.get()) {
            for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET ORE BLOCK
                Block oreBlock = ORE.getValue().getBlock();

                // CHECK IF ORE IS ENABLED IN CONFIG
                if (STONE_CONFIG.OPTIONS.get(oreName).get()) {
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

        if (GLOBAL_CONFIG.DENSE_ORE_GEN.get()) {
            for (Map.Entry<String, OreBlockProperties> ORE : StoneDense.ORES.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET ORE BLOCK
                Block oreBlock = ORE.getValue().getBlock();

                // CHECK IF ORE IS ENABLED IN CONFIG
                if (STONE_CONFIG.OPTIONS.get("DENSE_" + oreName).get()) {
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
