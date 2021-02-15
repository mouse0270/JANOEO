package fr.alasdiablo.janoeo.data;

import fr.alasdiablo.diolib.data.DioBlockLootTables;
import fr.alasdiablo.janoeo.init.*;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.LootTableProvider;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ModBlockLootTable extends DioBlockLootTables {

    private static class Provider {
        // Dense ore value : (base value 4.0F(min), 9.0F(max)) min = (base value max), max = (base value max) + (base value min) * 2, or 9.0F, 17.0F
        private static final Function<Block, LootTable.Builder> LAPIS_LOOT_PROVIDER = (lapis) -> droppingWithSilkTouch(lapis, withExplosionDecay(lapis, ItemLootEntry.builder(Items.LAPIS_LAZULI).acceptFunction(SetCount.builder(RandomValueRange.of(4.0F, 9.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> COAL_LOOT_PROVIDER =  (coal) -> droppingItemWithFortune(coal, Items.COAL);
        private static final Function<Block, LootTable.Builder> DIAMOND_LOOT_PROVIDER =  (diamond) -> droppingItemWithFortune(diamond, Items.DIAMOND);
        private static final Function<Block, LootTable.Builder> EMERALD_LOOT_PROVIDER =  (emerald) -> droppingItemWithFortune(emerald, Items.EMERALD);
        private static final Function<Block, LootTable.Builder> RUBY_LOOT_PROVIDER = (ruby) -> droppingItemWithFortune(ruby, GemsItems.RUBY);
        private static final Function<Block, LootTable.Builder> SAPPHIRE_LOOT_PROVIDER = (sapphire) -> droppingItemWithFortune(sapphire, GemsItems.SAPPHIRE);
        private static final Function<Block, LootTable.Builder> REDSTONE_LOOT_PROVIDER = (redstone) -> droppingWithSilkTouch(redstone, withExplosionDecay(redstone, ItemLootEntry.builder(Items.REDSTONE).acceptFunction(SetCount.builder(RandomValueRange.of(4.0F, 5.0F))).acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_LAPIS_LOOT_PROVIDER = (lapis) -> droppingWithSilkTouch(lapis, withExplosionDecay(lapis, ItemLootEntry.builder(Items.LAPIS_LAZULI).acceptFunction(SetCount.builder(RandomValueRange.of(9.0F, 17.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_COAL_LOOT_PROVIDER = (coal) -> droppingWithSilkTouch(coal, withExplosionDecay(coal, ItemLootEntry.builder(Items.COAL).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_REDSTONE_LOOT_PROVIDER = (redstone) -> droppingWithSilkTouch(redstone, withExplosionDecay(redstone, ItemLootEntry.builder(Items.REDSTONE).acceptFunction(SetCount.builder(RandomValueRange.of(9.0F, 17.0F))).acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_DIAMOND_LOOT_PROVIDER = (diamond) -> droppingWithSilkTouch(diamond, withExplosionDecay(diamond, ItemLootEntry.builder(Items.DIAMOND).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_EMERALD_LOOT_PROVIDER = (emerald) -> droppingWithSilkTouch(emerald, withExplosionDecay(emerald, ItemLootEntry.builder(Items.EMERALD).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_IRON_LOOT_PROVIDER = (iron) -> droppingWithSilkTouch(iron, withExplosionDecay(iron, ItemLootEntry.builder(Blocks.IRON_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_GOLD_LOOT_PROVIDER = (gold) -> droppingWithSilkTouch(gold, withExplosionDecay(gold, ItemLootEntry.builder(Blocks.GOLD_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        //private static final Function<Block, LootTable.Builder> DENSE_COPPER_LOOT_PROVIDER = (copper) -> droppingWithSilkTouch(copper, withExplosionDecay(copper, ItemLootEntry.builder(Stone.COPPER_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        //private static final Function<Block, LootTable.Builder> DENSE_TIN_LOOT_PROVIDER = (tin) -> droppingWithSilkTouch(tin, withExplosionDecay(tin, ItemLootEntry.builder(Stone.TIN_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        private static final Function<Block, LootTable.Builder> DENSE_QUARTZ_LOOT_PROVIDER = (quartz) -> droppingWithSilkTouch(quartz, withExplosionDecay(quartz, ItemLootEntry.builder(Items.QUARTZ).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        //private static final Function<Block, LootTable.Builder> DENSE_NETHER_IRON_LOOT_PROVIDER = (iron) -> droppingWithSilkTouch(iron, withExplosionDecay(iron, ItemLootEntry.builder(NetherOresBlocks.IRON_NETHER_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
        //private static final Function<Block, LootTable.Builder> DENSE_NETHER_GOLD_LOOT_PROVIDER = (gold) -> droppingWithSilkTouch(gold, withExplosionDecay(gold, ItemLootEntry.builder(NetherOresBlocks.GOLD_NETHER_ORE).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F))).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))));
    }

    private static <T> T getValueOrDefault(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    private void buildLootTable(String oreName, OreBlockProperties oreBlockProperties) {
        // GET ORE BLOCK
        Block oreBlock = oreBlockProperties.getBlock();
        // GET ORE LOOT TABLE OPTIONS
        LootTableProvider oreLootTable = oreBlockProperties.getLootTableProvider();

        if (oreLootTable == null) {
            this.registerDropSelfLootTable(oreBlock);
        }else{
            this.registerLootTable(oreBlock, (item) -> droppingWithSilkTouch(
                    item, withExplosionDecay(
                            item, ItemLootEntry.builder(getValueOrDefault(oreLootTable.getItem(), oreLootTable.getBlock())).acceptFunction(
                                    SetCount.builder(RandomValueRange.of(oreLootTable.getMinDropRate(), oreLootTable.getMaxDropRate()))
                            ).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))
                    )
            ));
        }
    }

    @Override
    protected void addTables() {
        // ----------------------------------------------------------------------------------------------
        // --------------------------------------- OVERWORLD.STONE --------------------------------------
        for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
            buildLootTable(ORE.getKey(), ORE.getValue());
        }

        // ------------------------------------ OVERWORLD.STONE.DENSE -----------------------------------
        for (Map.Entry<String, OreBlockProperties> ORE : StoneDense.ORES.entrySet()) {
            buildLootTable(ORE.getKey(), ORE.getValue());
        }

        //this.registerDropSelfLootTable(Stone.ALUMINIUM_ORE);
        //this.registerDropSelfLootTable(Stone.COPPER_ORE);
        //this.registerDropSelfLootTable(Stone.LEAD_ORE);
        //this.registerDropSelfLootTable(Stone.OSMIUM_ORE);
        //this.registerDropSelfLootTable(Stone.SILVER_ORE);
        //this.registerDropSelfLootTable(Stone.TIN_ORE);
        //this.registerDropSelfLootTable(Stone.URANIUM_ORE);
        //this.registerDropSelfLootTable(Stone.ZINC_ORE);

        //this.registerLootTable(Stone.AMETHYST_ORE, (amethyst) -> droppingItemWithFortune(amethyst, GemsItems.AMETHYST));
        //this.registerLootTable(Stone.RUBY_ORE, Provider.RUBY_LOOT_PROVIDER);
        //this.registerLootTable(Stone.SAPPHIRE_ORE, Provider.SAPPHIRE_LOOT_PROVIDER);

        //this.registerLootTable(StoneDense.DENSE_COAL_ORE, Provider.DENSE_COAL_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_COPPER_ORE, Provider.DENSE_COPPER_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_DIAMOND_ORE, Provider.DENSE_DIAMOND_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_EMERALD_ORE, Provider.DENSE_EMERALD_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_GOLD_ORE, Provider.DENSE_GOLD_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_IRON_ORE, Provider.DENSE_IRON_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_LAPIS_ORE, Provider.DENSE_LAPIS_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_REDSTONE_ORE, Provider.DENSE_REDSTONE_LOOT_PROVIDER);
        //this.registerLootTable(StoneDense.DENSE_TIN_ORE, Provider.DENSE_TIN_LOOT_PROVIDER);

        this.registerDropSelfLootTable(ModBlocks.RUBY_BLOCK);
        this.registerDropSelfLootTable(ModBlocks.SAPPHIRE_BLOCK);

        /*this.registerDropSelfLootTable(BasaltOresBlocks.GOLD_BASALT_ORE);
        this.registerDropSelfLootTable(BasaltOresBlocks.IRON_BASALT_ORE);
        this.registerDropSelfLootTable(EndOresBlocks.GOLD_END_ORE);
        this.registerDropSelfLootTable(EndOresBlocks.IRON_END_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.ALUMINIUM_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.COPPER_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.GOLD_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.IRON_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.OSMIUM_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.SILVER_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.LEAD_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.TIN_NETHER_ORE);
        this.registerDropSelfLootTable(NetherOresBlocks.URANIUM_NETHER_ORE);
        this.registerLootTable(BasaltOresBlocks.COAL_BASALT_ORE, Provider.COAL_LOOT_PROVIDER);
        this.registerLootTable(BasaltOresBlocks.DIAMOND_BASALT_ORE, Provider.DIAMOND_LOOT_PROVIDER);
        this.registerLootTable(BasaltOresBlocks.EMERALD_BASALT_ORE, Provider.EMERALD_LOOT_PROVIDER);
        this.registerLootTable(EndOresBlocks.COAL_END_ORE, Provider.COAL_LOOT_PROVIDER);
        this.registerLootTable(EndOresBlocks.DIAMOND_END_ORE, Provider.DIAMOND_LOOT_PROVIDER);
        this.registerLootTable(EndOresBlocks.EMERALD_END_ORE, Provider.EMERALD_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.COAL_NETHER_ORE, Provider.COAL_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.DIAMOND_NETHER_ORE, Provider.DIAMOND_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.EMERALD_NETHER_ORE, Provider.EMERALD_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.RUBY_NETHER_ORE, Provider.RUBY_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.SAPPHIRE_NETHER_ORE, Provider.SAPPHIRE_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.LAPIS_NETHER_ORE, Provider.LAPIS_LOOT_PROVIDER);
        this.registerLootTable(EndOresBlocks.LAPIS_END_ORE, Provider.LAPIS_LOOT_PROVIDER);
        this.registerLootTable(BasaltOresBlocks.LAPIS_BASALT_ORE, Provider.LAPIS_LOOT_PROVIDER);
        this.registerLootTable(NetherOresBlocks.REDSTONE_NETHER_ORE, Provider.REDSTONE_LOOT_PROVIDER);
        this.registerLootTable(EndOresBlocks.REDSTONE_END_ORE, Provider.REDSTONE_LOOT_PROVIDER);
        this.registerLootTable(BasaltOresBlocks.REDSTONE_BASALT_ORE, Provider.REDSTONE_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_COAL_NETHER_ORE, Provider.DENSE_COAL_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_DIAMOND_NETHER_ORE, Provider.DENSE_DIAMOND_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_EMERALD_NETHER_ORE, Provider.DENSE_EMERALD_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_GOLD_NETHER_ORE, Provider.DENSE_NETHER_GOLD_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_IRON_NETHER_ORE, Provider.DENSE_NETHER_IRON_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_LAPIS_NETHER_ORE, Provider.DENSE_LAPIS_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_REDSTONE_NETHER_ORE, Provider.DENSE_REDSTONE_LOOT_PROVIDER);
        this.registerLootTable(NetherDenseOresBlocks.DENSE_QUARTZ_NETHER_ORE, Provider.DENSE_QUARTZ_LOOT_PROVIDER);
        this.registerLootTable(GravelsOresBlocks.DIAMOND_GRAVEL_ORE, (diamond) -> droppingItemWithFortune(diamond, DustsItems.DIAMOND_DUST));
        this.registerLootTable(GravelsOresBlocks.GOLD_GRAVEL_ORE, (gold) -> droppingItemWithFortune(gold, DustsItems.GOLD_DUST));
        this.registerLootTable(GravelsOresBlocks.IRON_GRAVEL_ORE, (iron) -> droppingItemWithFortune(iron, DustsItems.IRON_DUST));
        this.registerLootTable(GravelsOresBlocks.LAPIS_GRAVEL_ORE, (lapis) -> droppingItemWithFortune(lapis, DustsItems.LAPIS_DUST));
        this.registerLootTable(GravelsOresBlocks.COAL_GRAVEL_ORE, (coal) -> droppingItemWithFortune(coal, DustsItems.COAL_DUST));
        this.registerLootTable(GravelsOresBlocks.EMERALD_GRAVEL_ORE, (emerald) -> droppingItemWithFortune(emerald, DustsItems.EMERALD_DUST));*/
    }
}
