package fr.alasdiablo.janoeo.init.ores;

import fr.alasdiablo.diolib.world.ExtenedFillerBlockType;
import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.block.*;
import fr.alasdiablo.janoeo.init.items.Dusts;
import fr.alasdiablo.janoeo.init.items.Gems;
import fr.alasdiablo.janoeo.util.LootTableProvider;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.HashMap;
import java.util.Map;

import static fr.alasdiablo.diolib.generic.ExperienceRarity.*;
import static fr.alasdiablo.janoeo.util.Registries.registryName;

public class Ores {
    public static Map<String, HashMap<String, OreBlockProperties>> ORE_DEFINITIONS = new HashMap<String, HashMap<String, OreBlockProperties>>() {{
        put("COAL_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.COAL_ORE, "STONE", "DENSE"), 1, COMMON),
                Blocks.COAL_ORE.getDefaultState(),
                new LootTableProvider(Items.COAL, 3.0f)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.COAL_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Dusts.getItem(Registries.COAL_ORE))
            ));
        }});
        put("IRON_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                    new BasicOre(registryName(Registries.IRON_ORE, "STONE", "DENSE"), 1, COMMON),
                    Blocks.IRON_ORE.getDefaultState(),
                    new LootTableProvider(Items.IRON_ORE, 3.0f)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.IRON_ORE, "SAND"), 1, COMMON),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Dusts.getItem(Registries.IRON_ORE))
            ));
        }});
        put("GOLD_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.GOLD_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Blocks.GOLD_ORE.getDefaultState(),
                new LootTableProvider(Items.GOLD_ORE, 3.0f)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.GOLD_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Dusts.getItem(Registries.GOLD_ORE))
            ));
        }});
        put("DIAMOND_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.DIAMOND_ORE, "STONE", "DENSE"), 2, RARE),
                Blocks.DIAMOND_ORE.getDefaultState(),
                new LootTableProvider(Items.DIAMOND, 3.0f)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.DIAMOND_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Dusts.getItem(Registries.DIAMOND_ORE))
            ));
        }});
        put("EMERALD_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.EMERALD_ORE, "STONE", "DENSE"), 2, RARE),
                Blocks.EMERALD_ORE.getDefaultState(),
                new LootTableProvider(Items.EMERALD, 3.0f)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.EMERALD_ORE, "SAND"), 2, RARE),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Dusts.getItem(Registries.EMERALD_ORE))
            ));
        }});
        put("LAPIS_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.LAPIS_ORE, "STONE", "DENSE"), 2, UNCOMMON),
                Blocks.LAPIS_ORE.getDefaultState(),
                new LootTableProvider(Items.LAPIS_LAZULI, 9.0F, 17.0F)
            ));
            put("SAND", new OreBlockProperties(
                new FallingOre(registryName(Registries.LAPIS_ORE, "SAND"), 2, UNCOMMON),
                ExtenedFillerBlockType.SAND.get(),
                new LootTableProvider(Items.LAPIS_LAZULI, 2.0f, 4.0f)
            ));
        }});
        put("REDSTONE_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.REDSTONE_ORE, "STONE", "DENSE"), 2, COMMON),
                Blocks.REDSTONE_ORE.getDefaultState(),
                new LootTableProvider(Items.REDSTONE, 9.0F, 17.0F)
            ));
        }});

        // --> MOODED ORE
        put("ALUMINIUM_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ALUMINIUM_ORE, "STONE"), 1, COMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ALUMINIUM_ORE, "STONE", "DENSE"), 1, RARE)
            ));
        }});
        put("AMETHYST_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.AMETHYST_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                new LootTableProvider(Gems.ITEMS.get("AMETHYST_GEM"))
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.AMETHYST_ORE, "STONE", "DENSE"), 1, RARE),
                new LootTableProvider(Gems.ITEMS.get("AMETHYST_GEM"), 3.0f)
            ));
        }});
        put("COPPER_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.COPPER_ORE, "STONE"), 1, COMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.COPPER_ORE, "STONE", "DENSE"), 1, RARE)
            ));
        }});
        put("LEAD_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.LEAD_ORE, "STONE"), 1, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.LEAD_ORE, "STONE", "DENSE"), 1, RARE)
            ));
        }});
        put("OSMIUM_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.OSMIUM_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.OSMIUM_ORE, "STONE", "DENSE"), 2, RARE)
            ));
        }});
        put("RUBY_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.RUBY_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                new LootTableProvider(Gems.ITEMS.get("RUBY_GEM"))
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.RUBY_ORE, "STONE", "DENSE"), 2, RARE),
                new LootTableProvider(Gems.ITEMS.get("RUBY_GEM"), 3.0f)
            ));
        }});
        put("SAPPHIRE_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.SAPPHIRE_ORE, "STONE"), 2, RARE),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                new LootTableProvider(Gems.ITEMS.get("SAPPHIRE_GEM"))
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.SAPPHIRE_ORE, "STONE", "DENSE"), 2, RARE),
                new LootTableProvider(Gems.ITEMS.get("SAPPHIRE_GEM"), 3.0f)
            ));
        }});
        put("SILVER_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.SILVER_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.SILVER_ORE, "STONE", "DENSE"), 2, RARE)
            ));
        }});
        put("TIN_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.TIN_ORE, "STONE"), 1, COMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.TIN_ORE, "STONE", "DENSE"), 1, RARE)
            ));
        }});
        put("URANIUM_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.URANIUM_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.URANIUM_ORE, "STONE", "DENSE"), 2, RARE)
            ));
        }});
        put("ZINC_ORE", new HashMap<String, OreBlockProperties>() {{
            put("STONE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ZINC_ORE, "STONE"), 2, UNCOMMON),
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD
            ));
            put("STONE.DENSE", new OreBlockProperties(
                new BasicOre(registryName(Registries.ZINC_ORE, "STONE", "DENSE"), 2, RARE)
            ));
        }});

        Janoeo.logger.debug("SETTING UP STONE ORES: ");
    }};
}
