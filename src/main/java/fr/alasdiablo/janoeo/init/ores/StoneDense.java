package fr.alasdiablo.janoeo.init.ores;

import static fr.alasdiablo.diolib.generic.ExperienceRarity.*;
import static fr.alasdiablo.janoeo.util.Registries.registryName;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.block.BasicOre;
import fr.alasdiablo.janoeo.block.RedstoneOre;
import fr.alasdiablo.janoeo.init.items.Gems;
import fr.alasdiablo.janoeo.util.JanoeoGroup;
import fr.alasdiablo.janoeo.util.LootTableProvider;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

/**
 * Dense Overworld Ore Block Handler
 */
@SuppressWarnings("unused")
public class StoneDense {

    public static Map<String, OreBlockProperties> ORES = new HashMap<String, OreBlockProperties>() {{
        put("COAL_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.COAL_ORE, "STONE", "DENSE"), 1, COMMON),
                Blocks.COAL_ORE.getDefaultState(),
                new LootTableProvider(Items.COAL, 3.0f)
        ));
        put("IRON_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.IRON_ORE, "STONE", "DENSE"), 1, COMMON),
                Blocks.IRON_ORE.getDefaultState(),
                new LootTableProvider(Items.IRON_ORE, 3.0f)
        ));
        put("GOLD_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.GOLD_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Blocks.GOLD_ORE.getDefaultState(),
                new LootTableProvider(Items.GOLD_ORE, 3.0f)
        ));
        put("DIAMOND_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.DIAMOND_ORE, "STONE", "DENSE"), 2, RARE),
                Blocks.DIAMOND_ORE.getDefaultState(),
                new LootTableProvider(Items.GOLD_ORE, 3.0f)
        ));
        put("EMERALD_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.EMERALD_ORE, "STONE", "DENSE"), 2, RARE),
                Blocks.EMERALD_ORE.getDefaultState(),
                new LootTableProvider(Items.GOLD_ORE, 3.0f)
        ));
        put("LAPIS_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.LAPIS_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Blocks.LAPIS_ORE.getDefaultState(),
                new LootTableProvider(Items.LAPIS_LAZULI, 9.0F, 17.0F)
        ));
        put("REDSTONE_ORE", new OreBlockProperties(
                new RedstoneOre(registryName(Registries.REDSTONE_ORE, "STONE", "DENSE"), 2, COMMON),
                Blocks.REDSTONE_ORE.getDefaultState(),
                new LootTableProvider(Items.REDSTONE, 9.0F, 17.0F)
        ));
        // --> MODDED ORES
        put("ALUMINIUM_ORE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ALUMINIUM_ORE, "STONE", "DENSE"), 1, COMMON),
                Stone.ORES.get("ALUMINIUM_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("ALUMINIUM_ORE").getBlock(), 3.0f)
        ));
        put("AMETHYST_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.AMETHYST_ORE, "STONE", "DENSE"), 2, RARE),
                Stone.ORES.get("AMETHYST_ORE").getBlockState(),
                new LootTableProvider(Gems.ITEMS.get("AMETHYST_GEM"), 3.0f)
        ));
        put("COPPER_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.COPPER_ORE, "STONE", "DENSE"), 1, COMMON),
                Stone.ORES.get("COPPER_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("COPPER_ORE").getBlock(), 3.0f)
        ));
        put("LEAD_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.LEAD_ORE, "STONE", "DENSE"), 1, UNCOMMON),
                Stone.ORES.get("LEAD_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("LEAD_ORE").getBlock(), 3.0f)
        ));
        put("OSMIUM_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.OSMIUM_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Stone.ORES.get("OSMIUM_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("OSMIUM_ORE").getBlock(), 3.0f)
        ));
        put("RUBY_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.RUBY_ORE, "STONE", "DENSE"), 2, RARE),
                Stone.ORES.get("RUBY_ORE").getBlockState(),
                new LootTableProvider(Gems.ITEMS.get("RUBY_GEM"), 3.0f)
        ));
        put("SAPPHIRE_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.SAPPHIRE_ORE, "STONE", "DENSE"), 2, RARE),
                Stone.ORES.get("SAPPHIRE_ORE").getBlockState(),
                new LootTableProvider(Gems.ITEMS.get("SAPPHIRE_GEM"), 3.0f)
        ));
        put("SILVER_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.SILVER_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Stone.ORES.get("SILVER_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("SILVER_ORE").getBlock(), 3.0f)
        ));
        put("TIN_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.TIN_ORE, "STONE", "DENSE"), 1, COMMON),
                Stone.ORES.get("TIN_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("TIN_ORE").getBlock(), 3.0f)
        ));
        put("URANIUM_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.URANIUM_ORE, "STONE", "DENSE"), 2, RARE),
                Stone.ORES.get("URANIUM_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("URANIUM_ORE").getBlock(), 3.0f)
        ));
        put("ZINC_ORE",  new OreBlockProperties(
                new BasicOre(registryName(Registries.ZINC_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Stone.ORES.get("ZINC_ORE").getBlockState(),
                new LootTableProvider(Stone.ORES.get("ZINC_ORE").getBlock(), 3.0f)
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
                // Used to Register Overlays on Blocks
                RenderTypeLookup.setRenderLayer(ORE.getValue().getBlock(), RenderType.getCutout());
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
                Janoeo.logger.debug("JANOEO DENSE STONE ORE -> REGISTER BLOCK ITEM: " + ORE.getValue().getBlock());
            }
        }
    }

}
