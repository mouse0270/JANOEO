package fr.alasdiablo.janoeo.util;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.template.RuleTest;

public class OreBlockProperties {
    public Boolean isEnabled;
    public Block block;
    public BlockState blockState;
    public RuleTest ruleTest;
    public LootTableProvider lootTableProvider;

    public OreBlockProperties(Boolean isEnabled, Block block, BlockState blockState, RuleTest ruleTest, LootTableProvider lootTableProvider) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.blockState = blockState;
        this.ruleTest = ruleTest;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, BlockState blockState, RuleTest ruleTest, LootTableProvider lootTableProvider) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = blockState;
        this.ruleTest = ruleTest;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, BlockState blockState, RuleTest ruleTest) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = blockState;
        this.ruleTest = ruleTest;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Boolean isEnabled, Block block, BlockState blockState, LootTableProvider lootTableProvider) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.blockState = blockState;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Boolean isEnabled, Block block, BlockState blockState) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.blockState = blockState;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Boolean isEnabled, Block block, RuleTest ruleTest, LootTableProvider lootTableProvider) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.ruleTest = ruleTest;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Boolean isEnabled, Block block, LootTableProvider lootTableProvider) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Boolean isEnabled, Block block) {
        this.isEnabled = isEnabled;
        this.block = block;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, BlockState blockState, LootTableProvider lootTableProvider) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = blockState;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, BlockState blockState) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = blockState;
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, RuleTest ruleTest, LootTableProvider lootTableProvider) {
        this.isEnabled = true;
        this.block = block;
        this.ruleTest = ruleTest;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }
    public OreBlockProperties(Block block, RuleTest ruleTest) {
        this.isEnabled = true;
        this.block = block;
        this.ruleTest = ruleTest;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }

    public OreBlockProperties(Block block, LootTableProvider lootTableProvider) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }

    public OreBlockProperties(Block block) {
        this.isEnabled = true;
        this.block = block;
        this.blockState = block.getDefaultState();
        this.lootTableProvider = lootTableProvider;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public Block getBlock() {
        return block;
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public RuleTest getRuleTest() {
        return ruleTest;
    }

    public LootTableProvider getLootTableProvider() {
        return lootTableProvider;
    }
}
