package fr.alasdiablo.janoeo.init.ores;

import static fr.alasdiablo.diolib.generic.ExperienceRarity.*;
import static fr.alasdiablo.janoeo.util.Registries.registryName;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.ExtenedFillerBlockType;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.block.BasicOre;
import fr.alasdiablo.janoeo.block.FallingOre;
import fr.alasdiablo.janoeo.block.RedstoneOre;
import fr.alasdiablo.janoeo.init.GemsItems;
import fr.alasdiablo.janoeo.util.JanoeoGroup;
import fr.alasdiablo.janoeo.util.LootTableProvider;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.StandaloneLootEntry;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

/**
 * Overworld Ore Block Handler
 */
@SuppressWarnings("unused")
public class Stone {

    public static Map<String, OreBlockProperties> ORES = new HashMap<String, OreBlockProperties>() {{
        // --> MODDED ORES
        put("ALUMINIUM_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ALUMINIUM_ORE, "STONE"), 1, COMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("AMETHYST_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.AMETHYST_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                new LootTableProvider(GemsItems.AMETHYST)
        ));
        put("COPPER_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.COPPER_ORE, "STONE"), 1, COMMON),
                Blocks.STONE.getDefaultState()
        ));
        put("LEAD_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.LEAD_ORE, "STONE"), 1, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("OSMIUM_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.OSMIUM_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("RUBY_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.RUBY_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("SAPPHIRE_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.SAPPHIRE_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("SILVER_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.SILVER_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("TIN_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.TIN_ORE, "STONE"), 1, COMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("URANIUM_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.URANIUM_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
        put("ZINC_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.ZINC_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
        ));
    }};

    /**
     * Registry Event Handler
     */
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        /**
         * Handle Block registries
         *
         * @param event Instance of the event
         */
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            for (Map.Entry<String, OreBlockProperties> ORE : ORES.entrySet()) {
                RegistryHelper.registerBlock(event.getRegistry(), ORE.getValue().getBlock());
                Janoeo.logger.debug("REGISTER BLOCK: " + ORE.getValue().getBlock());
            }
        }

        /**
         * Handle Item registries
         *
         * @param event Instance of the event
         */
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            for (Map.Entry<String, OreBlockProperties> ORE : ORES.entrySet()) {
                RegistryHelper.registerBlockItem(event.getRegistry(), new Item.Properties().group(JanoeoGroup.ORE_BLOCKS), ORE.getValue().getBlock());
                Janoeo.logger.debug("REGISTER BLOCK ITEM: " + ORE.getValue().getBlock());
            }
        }
    }
}
