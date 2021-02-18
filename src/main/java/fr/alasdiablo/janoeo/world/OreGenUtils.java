package fr.alasdiablo.janoeo.world;

import fr.alasdiablo.janoeo.config.ores.SandConfig;
import fr.alasdiablo.janoeo.config.ores.StoneConfig;
import fr.alasdiablo.janoeo.init.ores.Sand;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.world.util.IWorldGenerator;
import fr.alasdiablo.janoeo.world.gen.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Class use for handle the ore generation
 */
public class OreGenUtils {

    // Instance of OreGenerator
    private static final IWorldGenerator STONE_ORE_GENERATOR = new OreGenerator();
    private static final IWorldGenerator SAND_ORE_GENERATOR = new OreGenerator();
    private static final IWorldGenerator LOG_BIRCH_ORE_GENERATOR = new OreGenerator();

    /**
     * Initialized the ore generation
     */
    public static void initOreGen() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            switch (biome.getCategory()) {
                case NETHER:
                    //NETHER_GENERATOR.startWorldGeneration(biome, "");
                    //BASALT_GENERATOR.startWorldGeneration(biome, "");
                    break;
                case THEEND:
                    //END_GENERATOR.startWorldGeneration(biome, "");
                    break;
                case OCEAN:
                    break;
                default:
                    STONE_ORE_GENERATOR.startWorldGeneration(biome, StoneConfig.CONFIG.OPTIONS, Stone.ORES, StoneDense.ORES, "OVERWORLD.STONE", null);
                    SAND_ORE_GENERATOR.startWorldGeneration(biome, SandConfig.CONFIG.OPTIONS, Sand.ORES, null, "OVERWORLD.STONE", null);
                    //GRAVEL_ORE_GENEATOR.startWorldGeneration(biome, "OVERWORLD.GRAVEL", "");
                    break;
            }
        }
    }
}
