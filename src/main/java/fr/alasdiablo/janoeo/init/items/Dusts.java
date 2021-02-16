package fr.alasdiablo.janoeo.init.items;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.init.Items;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.JanoeoGroup;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.alasdiablo.janoeo.util.Registries.registryName;

public class Dusts {

    private static final Item.Properties PROPERTIES = new Item.Properties().group(JanoeoGroup.ORE_ITEMS);

    public static Map<String, Item> ITEMS = new HashMap<String, Item>() {{
        for (Map.Entry<String, List<String>> item : Items.ITEMS.entrySet()) {
            if (ArrayUtils.contains(item.getValue().toArray(new String[]{}), "has_dust")) {
                put(
                    registryName(item.getKey(), null, "DUST").toUpperCase(),
                    new Item(PROPERTIES).setRegistryName(registryName(item.getKey(), null, "DUST"))
                );
            }
        }
    }};


    /**
     * Registry Event Handler
     */
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        /**
         * Handle Item registries
         *
         * @param event Instance of the event
         */
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            RegistryHelper.registerItem(event.getRegistry(), ITEMS.values().toArray(new Item[]{}));
        }
    }
}
