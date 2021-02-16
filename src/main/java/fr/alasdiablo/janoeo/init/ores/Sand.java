package fr.alasdiablo.janoeo.init.ores;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.diolib.world.ExtenedFillerBlockType;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.block.BasicOre;
import fr.alasdiablo.janoeo.block.FallingOre;
import fr.alasdiablo.janoeo.block.RedstoneOre;
import fr.alasdiablo.janoeo.util.JanoeoGroup;
import fr.alasdiablo.janoeo.util.LootTableProvider;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

import static fr.alasdiablo.diolib.generic.ExperienceRarity.*;
import static fr.alasdiablo.janoeo.util.Registries.registryName;

/**
 * Overworld Ore Block Handler
 */
@SuppressWarnings("unused")
public class Sand {

    public static Map<String, OreBlockProperties> ORES = new HashMap<String, OreBlockProperties>() {{
        put("COAL_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.COAL_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("IRON_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.IRON_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("GOLD_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.GOLD_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("DIAMOND_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.DIAMOND_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("EMERALD_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.EMERALD_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("LAPIS_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.LAPIS_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        /*put("REDSTONE_ORE", new OreBlockProperties(
                new RedstoneOre(registryName(Registries.REDSTONE_ORE, "SAND"), 2, COMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        // --> MODDED ORES
        put("ALUMINIUM_ORE", new OreBlockProperties(
                new FallingOre(registryName(Registries.ALUMINIUM_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("AMETHYST_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.AMETHYST_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(GemsItems.AMETHYST)
        ));
        put("COPPER_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.COPPER_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get(),
        ));
        put("LEAD_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.LEAD_ORE, "SAND"), 1, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("OSMIUM_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.OSMIUM_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("RUBY_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.RUBY_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("SAPPHIRE_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.SAPPHIRE_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("SILVER_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.SILVER_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("TIN_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.TIN_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("URANIUM_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.URANIUM_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));
        put("ZINC_ORE",  new OreBlockProperties(
                new FallingOre(registryName(Registries.ZINC_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get()
        ));*/
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
