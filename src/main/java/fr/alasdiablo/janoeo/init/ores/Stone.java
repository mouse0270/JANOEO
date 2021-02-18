package fr.alasdiablo.janoeo.init.ores;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.util.JanoeoGroup;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
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
        for (Map.Entry<String, HashMap<String, OreBlockProperties>> ORE : Ores.ORE_DEFINITIONS.entrySet()) {
            String oreKey = ORE.getKey();
            Map<String, OreBlockProperties> oreProperties = ORE.getValue();

            if (oreProperties.containsKey("STONE")) {
                OreBlockProperties oreProperty = oreProperties.get("STONE");

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
                Janoeo.logger.debug("REGISTER BLOCK ITEM: " + ORE.getValue().getBlock());
            }
        }
    }
}
