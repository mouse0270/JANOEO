package fr.alasdiablo.janoeo.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LootTableProvider {
    public Item item;
    public Block block;
    public float minDropRate;
    public float maxDropRate;

    public LootTableProvider(Block block, float minDropRate, float maxDropRate) {
        this.block = block;
        this.minDropRate = minDropRate;
        this.maxDropRate = maxDropRate;
    }

    public LootTableProvider(Item item, float minDropRate, float maxDropRate) {
        this.item = item;
        this.minDropRate = minDropRate;
        this.maxDropRate = maxDropRate;
    }

    public LootTableProvider(Block block, float maxDropRate) {
        this.block = block;
        this.minDropRate = 1.0f;
        this.maxDropRate = maxDropRate;
    }

    public LootTableProvider(Item item, float maxDropRate) {
        this.item = item;
        this.minDropRate = 1.0f;
        this.maxDropRate = maxDropRate;
    }


    public LootTableProvider(Block block) {
        this.block = block;
        this.minDropRate = 1.0f;
        this.maxDropRate = 1.0f;
    }

    public LootTableProvider(Item item) {
        this.item = item;
        this.minDropRate = 1.0f;
        this.maxDropRate = 1.0f;
    }

    public Item getItem() { return item; }

    public Block getBlock() { return block; }

    public float getMinDropRate() { return minDropRate; }

    public float getMaxDropRate() { return maxDropRate; }
}
