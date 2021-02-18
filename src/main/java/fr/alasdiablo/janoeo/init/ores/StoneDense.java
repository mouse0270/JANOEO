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
        for (Map.Entry<String, HashMap<String, OreBlockProperties>> ORE : Ores.ORE_DEFINITIONS.entrySet()) {
            String oreKey = ORE.getKey();
            Map<String, OreBlockProperties> oreProperties = ORE.getValue();

            if (oreProperties.containsKey("STONE.DENSE")) {
                OreBlockProperties oreProperty = oreProperties.get("STONE.DENSE");

                if (Stone.ORES.containsKey(oreKey) && oreProperty.getBlockState() == null) {
                    oreProperty.blockState = Stone.ORES.get(oreKey).getBlockState();
                }

                put(oreKey, oreProperty);
            }
        }
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
