package fr.alasdiablo.janoeo.world;

import fr.alasdiablo.janoeo.world.util.IWorldGenerator;
import fr.alasdiablo.janoeo.world.gen.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Class use for handle the ore generation
 */
public class OreGenUtils {

    // Instance of StoneOreGenerator
    private static final IWorldGenerator STONE_ORE_GENERATOR = new StoneOreGenerator();

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
                    STONE_ORE_GENERATOR.startWorldGeneration(biome, "OVERWORLD.STONE", "");
                    //GRAVEL_ORE_GENEATOR.startWorldGeneration(biome, "OVERWORLD.GRAVEL", "");
                    break;
            }
        }
    }
}
