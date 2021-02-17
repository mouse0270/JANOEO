package fr.alasdiablo.janoeo.data;

import fr.alasdiablo.diolib.util.RegistryHelper;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.init.*;
import fr.alasdiablo.janoeo.init.items.Dusts;
import fr.alasdiablo.janoeo.init.items.Ingots;
import fr.alasdiablo.janoeo.init.ores.Sand;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import fr.alasdiablo.janoeo.util.StringUtils;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.GameData;

import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class SmeltingBlastingRecipes extends RecipeProvider {
    public SmeltingBlastingRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private Item getSmeltingItem(String baseName) {
        Item smeltingItem = Items.AIR;

        try {
            if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Registries.MODID, Registries.registryName(baseName, null, "ingot"))) != Items.AIR) {
                smeltingItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Registries.MODID, Registries.registryName(baseName, null, "ingot")));
            }else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(Registries.MODID, Registries.registryName(baseName, null, "gem"))) != Items.AIR) {
                smeltingItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Registries.MODID, Registries.registryName(baseName, null, "gem")));
            }else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", Registries.registryName(baseName, null, "ingot"))) != Items.AIR) {
                smeltingItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", Registries.registryName(baseName, null, "ingot")));
            }else if (ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", Registries.registryName(baseName, null, null))) != Items.AIR) {
                smeltingItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("minecraft", Registries.registryName(baseName, null, null)));
            }
        }catch (Exception ex) {
            Janoeo.logger.debug("FAILED TO SMELT EXCEPTION:" + ex);
        }


        return smeltingItem;
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        // ----------------------------------------------------------------------------------------------
        // ------------------------------------- SMELTING.ORES.STONE ------------------------------------
        for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
            String baseName = StringUtils.cleanOreName(ORE.getKey(), true);
            String ingotName = Registries.registryName(baseName, null, "ingot").toUpperCase();

            if (getSmeltingItem(baseName) != Items.AIR) {
                this.registerSmeltingBlasting(ORE.getValue().getBlock(), getSmeltingItem(baseName), Registries.registryName(baseName, "has", "ore"), consumer);
            }else{
                Janoeo.logger.debug("FAILED TO SMELT: " + ORE.getKey());
            }
        }
        // ------------------------------------- SMELTING.ORES.SAND -------------------------------------
        for (Map.Entry<String, OreBlockProperties> ORE : Sand.ORES.entrySet()) {
            String baseName = StringUtils.cleanOreName(ORE.getKey(), true);
            String ingotName = Registries.registryName(baseName, null, "ingot").toUpperCase();

            if (getSmeltingItem(baseName) != Items.AIR) {
                this.registerSmeltingBlasting(ORE.getValue().getBlock(), getSmeltingItem(baseName), Registries.registryName(baseName, "has", "ore"), consumer);
            }else{
                Janoeo.logger.debug("FAILED TO SMELT: " + ORE.getKey() + " " + baseName);
            }
        }

        // ----------------------------------------------------------------------------------------------
        // ---------------------------------------- SMELTING.DUST ---------------------------------------
        // --> HANDLE DEFAULT MINECRAFT ITEMS
        //this.registerSmeltingBlasting(Dusts.ITEMS.get("COAL_DUST"), Items.COAL, "has_coal_dust", consumer);
        //this.registerSmeltingBlasting(Dusts.ITEMS.get("IRON_DUST"), Items.IRON_INGOT, "has_iron_dust", consumer);
        //this.registerSmeltingBlasting(Dusts.ITEMS.get("GOLD_DUST"), Items.GOLD_INGOT, "has_iron_dust", consumer);
        //this.registerSmeltingBlasting(Dusts.ITEMS.get("DIAMOND_DUST"), Items.DIAMOND, "has_diamond_dust", consumer);
        //this.registerSmeltingBlasting(Dusts.ITEMS.get("EMERALD_DUST"), Items.EMERALD, "has_emerald_dust", consumer);
        // --> MODDED ITEMS
        for (Map.Entry<String, Item> DUST : Dusts.ITEMS.entrySet()) {
            String baseName = StringUtils.cleanOreName(DUST.getKey(), true);
            String ingotName = Registries.registryName(baseName, null, "ingot").toUpperCase();


            if (getSmeltingItem(baseName) != Items.AIR) {
                this.registerSmeltingBlasting(DUST.getValue(), getSmeltingItem(baseName), Registries.registryName(baseName, "has", "dust"), consumer);
            }else{
                Janoeo.logger.debug("FAILED TO SMELT: " + DUST.getKey());
            }
        }

        /*this.registerSmeltingBlasting(Stone.COPPER_ORE, AllItems.Ingots.COPPER,"has_copper_ore", consumer);
        this.registerSmeltingBlasting(Stone.TIN_ORE, AllItems.Ingots.TIN, "has_tin_ore", consumer);
        this.registerSmeltingBlasting(Stone.ALUMINIUM_ORE, AllItems.Ingots.ALUMINIUM, "has_aluminium_ore", consumer);
        this.registerSmeltingBlasting(Stone.LEAD_ORE, AllItems.Ingots.LEAD, "has_lead_ore", consumer);
        this.registerSmeltingBlasting(Stone.SILVER_ORE, AllItems.Ingots.SILVER, "has_silver_ore", consumer);
        this.registerSmeltingBlasting(Stone.URANIUM_ORE, AllItems.Ingots.URANIUM, "has_uranium_ore", consumer);
        this.registerSmeltingBlasting(Stone.OSMIUM_ORE, AllItems.Ingots.OSMIUM, "has_osmium_ore", consumer);
        this.registerSmeltingBlasting(Stone.RUBY_ORE, AllItems.Gems.RUBY, "has_ruby_ore", consumer);
        this.registerSmeltingBlasting(Stone.SAPPHIRE_ORE, AllItems.Gems.SAPPHIRE, "has_sapphire_ore", consumer);
        this.registerSmeltingBlasting(Stone.AMETHYST_ORE, AllItems.Gems.AMETHYST, "has_amethyst_ore", consumer);
        this.registerSmeltingBlasting(Stone.ZINC_ORE, AllItems.Ingots.ZINC, "has_zinc_ore", consumer);*/

        /*this.registerSmeltingBlasting(DustsItems.IRON_DUST, Items.IRON_INGOT, "has_iron_dust", consumer);
        this.registerSmeltingBlasting(DustsItems.GOLD_DUST, Items.GOLD_INGOT, "has_gold_dust", consumer);
        this.registerSmeltingBlasting(DustsItems.DIAMOND_DUST, Items.DIAMOND, "has_diamond_dust", consumer);
        this.registerSmeltingBlasting(DustsItems.COAL_DUST, Items.COAL, "has_coal_dust", consumer);
        this.registerSmeltingBlasting(DustsItems.LAPIS_DUST, Items.LAPIS_LAZULI, "has_lapis_dust", consumer);
        this.registerSmeltingBlasting(DustsItems.EMERALD_DUST, Items.EMERALD, "has_emerald_dust", consumer);*/

        /*this.registerSmeltingBlasting(GravelsOresBlocks.IRON_GRAVEL_ORE, Items.IRON_INGOT, "has_gravel_iron_ore", consumer);
        this.registerSmeltingBlasting(GravelsOresBlocks.GOLD_GRAVEL_ORE, Items.GOLD_INGOT, "has_gravel_gold_ore", consumer);
        this.registerSmeltingBlasting(GravelsOresBlocks.DIAMOND_GRAVEL_ORE, Items.DIAMOND, "has_gravel_diamond_ore", consumer);
        this.registerSmeltingBlasting(GravelsOresBlocks.COAL_GRAVEL_ORE, Items.COAL, "has_gravel_coal_ore", consumer);
        this.registerSmeltingBlasting(GravelsOresBlocks.LAPIS_GRAVEL_ORE, Items.LAPIS_LAZULI, "has_gravel_lapis_ore", consumer);
        this.registerSmeltingBlasting(GravelsOresBlocks.EMERALD_GRAVEL_ORE, Items.EMERALD, "has_gravel_emerald_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.COAL_END_ORE, Items.COAL, "has_end_coal_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.DIAMOND_END_ORE, Items.DIAMOND, "has_end_diamond_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.EMERALD_END_ORE, Items.EMERALD, "has_end_emerald_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.GOLD_END_ORE, Items.GOLD_INGOT, "has_end_gold_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.IRON_END_ORE, Items.IRON_INGOT, "has_end_iron_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.LAPIS_END_ORE, Items.LAPIS_LAZULI, "has_end_lapis_ore", consumer);
        this.registerSmeltingBlasting(EndOresBlocks.REDSTONE_END_ORE, Items.REDSTONE, "has_end_redstone_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.COAL_NETHER_ORE, Items.COAL, "has_nether_coal_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.DIAMOND_NETHER_ORE, Items.DIAMOND, "has_nether_diamond_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.EMERALD_NETHER_ORE, Items.EMERALD, "has_nether_emerald_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.GOLD_NETHER_ORE, Items.GOLD_INGOT, "has_nether_gold_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.IRON_NETHER_ORE, Items.IRON_INGOT, "has_nether_iron_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.LAPIS_NETHER_ORE, Items.LAPIS_LAZULI, "has_nether_lapis_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.REDSTONE_NETHER_ORE, Items.REDSTONE, "has_nether_redstone_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.ALUMINIUM_NETHER_ORE, AllItems.Ingots.ALUMINIUM, "has_nether_aluminium_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.LEAD_NETHER_ORE, AllItems.Ingots.LEAD, "has_nether_lead_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.RUBY_NETHER_ORE, AllItems.Gems.RUBY, "has_nether_ruby_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.SAPPHIRE_NETHER_ORE, AllItems.Gems.SAPPHIRE, "has_nether_sapphire_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.SILVER_NETHER_ORE, AllItems.Ingots.SILVER, "has_nether_silver_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.URANIUM_NETHER_ORE, AllItems.Ingots.URANIUM, "has_nether_uranium_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.TIN_NETHER_ORE, AllItems.Ingots.TIN, "has_nether_tin_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.COPPER_NETHER_ORE, AllItems.Ingots.COPPER, "has_nether_copper_ore", consumer);
        this.registerSmeltingBlasting(NetherOresBlocks.OSMIUM_NETHER_ORE, AllItems.Ingots.OSMIUM, "has_nether_osmium_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.COAL_BASALT_ORE, Items.COAL, "has_basalt_coal_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.REDSTONE_BASALT_ORE, Items.REDSTONE, "has_basalt_redstone_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.DIAMOND_BASALT_ORE, Items.DIAMOND, "has_basalt_diamond_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.EMERALD_BASALT_ORE, Items.EMERALD, "has_basalt_emerald_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.GOLD_BASALT_ORE, Items.GOLD_INGOT, "has_basalt_gold_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.IRON_BASALT_ORE, Items.IRON_INGOT, "has_basalt_iron_ore", consumer);
        this.registerSmeltingBlasting(BasaltOresBlocks.LAPIS_BASALT_ORE, Items.LAPIS_LAZULI, "has_basalt_lapis_ore", consumer);*/
    }

    private void registerSmeltingBlasting(IItemProvider ingredientIn, IItemProvider resultIn, String criterion, Consumer<IFinishedRecipe> consumer) {
        final ResourceLocation name = new ResourceLocation(Registries.MODID, String.format("%s_to_%s", ingredientIn.asItem().getRegistryName().getPath(), resultIn.asItem().getRegistryName().getPath()));
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ingredientIn), resultIn, 0.1f, 200).addCriterion(criterion, hasItem(ingredientIn)).build(consumer, RegistryHelper.setPrefixOnRegistryName(name, "smelting"));
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ingredientIn), resultIn, 0.1f, 100).addCriterion(criterion, hasItem(ingredientIn)).build(consumer, RegistryHelper.setPrefixOnRegistryName(name, "blasting"));
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String getName() {
        return "Janoeo - Smelting Blasting";
    }
}
