package fr.alasdiablo.janoeo.util;

import fr.alasdiablo.diolib.gui.GroundItemGroup;
import fr.alasdiablo.janoeo.init.ores.Stone;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * Creative Tab handler
 */
public class JanoeoGroup {

    /**
     * Creative tab use by ore block
     */
    public static final ItemGroup ORE_BLOCKS = new GroundItemGroup("janoeo.ore.block") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Stone.ORES.get("COPPER_ORE").getBlock());
        }
    };

    /**
     * Creative tab use by item
     */
    public static final ItemGroup ORE_ITEMS = new GroundItemGroup("janoeo.ore.item") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Stone.ORES.get("COPPER_ORE").getBlock());
        }
    };
}
