package fr.alasdiablo.janoeo.util;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.annotation.Nullable;

/**
 * class with all registry name
 */
public class Registries {
    // ------------------------------------- REGISTRIES FUNCTIONS -----------------------------------
    public static String registryName(String registryName,  @Nullable String prefix, @Nullable String suffix) {
        if (prefix != null) registryName = prefix + "_" + registryName;
        if (suffix != null) registryName = registryName + "_" + suffix;

        return registryName.toLowerCase();
    }
    public static String registryName(String registryName, @Nullable String prefix, @Nullable String suffix, Boolean cleanName) {
        return registryName(StringUtils.cleanOreName(registryName, true), prefix, suffix);
    }
    public static String registryName(String registryName, String prefix) {
        return registryName(registryName, prefix, null);
    }

    // --------------------------------------- CORE REGISTRIES --------------------------------------
    public static final String MODID						= "janoeo";

    // --------------------------------------- overworld.stone --------------------------------------
    public static final String COAL_ORE                    = "coal_ore";
    public static final String IRON_ORE                    = "iron_ore";
    public static final String GOLD_ORE                    = "gold_ore";
    public static final String DIAMOND_ORE                 = "diamond_ore";
    public static final String EMERALD_ORE                 = "emerald_ore";
    public static final String LAPIS_ORE                   = "lapis_ore";
    public static final String REDSTONE_ORE                = "redstone_ore";
    // --> MODDED ORE
    public static final String ALUMINIUM_ORE               = "aluminium_ore";
    public static final String AMBER_ORE                   = "amber_ore";
    public static final String AMETHYST_ORE                = "amethyst_ore";
    public static final String APATITE_ORE                 = "apatite_ore";
    public static final String BITUMINOUS_ORE              = "bituminous_ore";
    public static final String CINNABAR_ORE                = "cinnabar_ore";
    public static final String COPPER_ORE                  = "copper_ore";
    public static final String LEAD_ORE                    = "lead_ore";
    public static final String NICKEL_ORE                  = "nickel_ore";
    public static final String NITER_ORE                   = "niter_ore";
    public static final String OSMIUM_ORE                  = "osmium_ore";
    public static final String PLATINUM_ORE                = "platinum_ore";
    public static final String RUBY_ORE                    = "ruby_ore";
    public static final String SALTPETER_ORE               = "saltpeter_ore";
    public static final String SAPPHIRE_ORE                = "sapphire_ore";
    public static final String SILVER_ORE                  = "silver_ore";
    public static final String SULFUR_ORE                  = "sulfur_ore";
    public static final String TIN_ORE                     = "tin_ore";
    public static final String URANIUM_ORE                 = "uranium_ore";
    public static final String ZINC_ORE                    = "zinc_ore";

    // ------------------------------------ overworld.stone.dense -----------------------------------
    public static final String DENSE_COAL_ORE             = "dense_coal_ore";
    public static final String DENSE_IRON_ORE             = "dense_iron_ore";
    public static final String DENSE_GOLD_ORE             = "dense_gold_ore";
    public static final String DENSE_DIAMOND_ORE          = "dense_diamond_ore";
    public static final String DENSE_EMERALD_ORE          = "dense_emerald_ore";
    public static final String DENSE_LAPIS_ORE            = "dense_lapis_ore";
    public static final String DENSE_REDSTONE_ORE         = "dense_redstone_ore";
    // --> MODDED ORE
    public static final String DENSE_ALUMINIUM_ORE        = "dense_aluminium_ore";
    public static final String DENSE_AMBER_ORE            = "dense_amber_ore";
    public static final String DENSE_AMETHYST_ORE         = "dense_amethyst_ore";
    public static final String DENSE_APATITE_ORE          = "dense_apatite_ore";
    public static final String DENSE_BITUMINOUS_ORE       = "dense_bituminous_ore";
    public static final String DENSE_CINNABAR_ORE         = "dense_cinnabar_ore";
    public static final String DENSE_COPPER_ORE           = "dense_copper_ore";
    public static final String DENSE_LEAD_ORE             = "dense_lead_ore";
    public static final String DENSE_NICKEL_ORE           = "dense_nickel_ore";
    public static final String DENSE_NITER_ORE            = "dense_niter_ore";
    public static final String DENSE_OSMIUM_ORE           = "dense_osmium_ore";
    public static final String DENSE_PLATINUM_ORE         = "dense_platinum_ore";
    public static final String DENSE_RUBY_ORE             = "dense_ruby_ore";
    public static final String DENSE_SALTPETER_ORE        = "dense_saltpeter_ore";
    public static final String DENSE_SAPPHIRE_ORE         = "dense_sapphire_ore";
    public static final String DENSE_SILVER_ORE           = "dense_silver_ore";
    public static final String DENSE_SULFUR_ORE           = "dense_sulfur_ore";
    public static final String DENSE_TIN_ORE              = "dense_tin_ore";
    public static final String DENSE_URANIUM_ORE          = "dense_uranium_ore";
    public static final String DENSE_ZINC_ORE             = "dense_zinc_ore";


    // -------------------------------------- overworld.gravel --------------------------------------
    public static final String COAL_GRAVEL_ORE             = "coal_gravel_ore";
    public static final String IRON_GRAVEL_ORE             = "iron_gravel_ore";
    public static final String GOLD_GRAVEL_ORE             = "gold_gravel_ore";
    public static final String DIAMOND_GRAVEL_ORE          = "diamond_gravel_ore";
    public static final String EMERALD_GRAVEL_ORE          = "emerald_gravel_ore";
    public static final String LAPIS_GRAVEL_ORE            = "lapis_gravel_ore";
    public static final String REDSTONE_GRAVEL_ORE         = "redstone_gravel_ore";
    // --> MODDED ORE
    public static final String ALUMINIUM_GRAVEL_ORE        = "aluminium_gravel_ore";
    public static final String AMBER_GRAVEL_ORE            = "amber_gravel_ore";
    public static final String AMETHYST_GRAVEL_ORE         = "amethyst_gravel_ore";
    public static final String APATITE_GRAVEL_ORE          = "apatite_gravel_ore";
    public static final String BITUMINOUS_GRAVEL_ORE       = "bituminous_gravel_ore";
    public static final String CINNABAR_GRAVEL_ORE         = "cinnabar_gravel_ore";
    public static final String COPPER_GRAVEL_ORE           = "copper_gravel_ore";
    public static final String LEAD_GRAVEL_ORE             = "lead_gravel_ore";
    public static final String NICKEL_GRAVEL_ORE           = "nickel_gravel_ore";
    public static final String NITER_GRAVEL_ORE            = "niter_gravel_ore";
    public static final String OSMIUM_GRAVEL_ORE           = "osmium_gravel_ore";
    public static final String PLATINUM_GRAVEL_ORE         = "platinum_gravel_ore";
    public static final String RUBY_GRAVEL_ORE             = "ruby_gravel_ore";
    public static final String SALTPETER_GRAVEL_ORE        = "saltpeter_gravel_ore";
    public static final String SAPPHIRE_GRAVEL_ORE         = "sapphire_gravel_ore";
    public static final String SILVER_GRAVEL_ORE           = "silver_gravel_ore";
    public static final String SULFUR_GRAVEL_ORE           = "sulfur_gravel_ore";
    public static final String TIN_GRAVEL_ORE              = "tin_gravel_ore";
    public static final String URANIUM_GRAVEL_ORE          = "uranium_gravel_ore";
    public static final String ZINC_GRAVEL_ORE             = "zinc_gravel_ore";


    // ----------------------------------- overworld.gravel.dense -----------------------------------

    // --------------------------------------- overworld.sand ---------------------------------------
    public static final String COAL_SAND_ORE             = "coal_sand_ore";
    public static final String IRON_SAND_ORE             = "iron_sand_ore";
    public static final String GOLD_SAND_ORE             = "gold_sand_ore";
    public static final String DIAMOND_SAND_ORE          = "diamond_sand_ore";
    public static final String EMERALD_SAND_ORE          = "emerald_sand_ore";
    public static final String LAPIS_SAND_ORE            = "lapis_sand_ore";
    public static final String REDSTONE_SAND_ORE         = "redstone_sand_ore";
    // --> MODDED ORE
    public static final String COPPER_SAND_ORE           = "copper_sand_ore";

    // ------------------------------------ overworld.sand.dense ------------------------------------


    // -------------------------------------------- nether ------------------------------------------
    public static final String COAL_NETHER_ORE             = "coal_nether_ore";
    public static final String IRON_NETHER_ORE             = "iron_nether_ore";
    public static final String GOLD_NETHER_ORE             = "gold_nether_ore";
    public static final String DIAMOND_NETHER_ORE          = "diamond_nether_ore";
    public static final String EMERALD_NETHER_ORE          = "emerald_nether_ore";
    public static final String LAPIS_NETHER_ORE            = "lapis_nether_ore";
    public static final String REDSTONE_NETHER_ORE         = "redstone_nether_ore";
    // --> MODDED ORE
    public static final String ALUMINIUM_NETHER_ORE        = "aluminium_nether_ore";
    public static final String AMBER_NETHER_ORE            = "amber_nether_ore";
    public static final String AMETHYST_NETHER_ORE         = "amethyst_nether_ore";
    public static final String APATITE_NETHER_ORE          = "apatite_nether_ore";
    public static final String BITUMINOUS_NETHER_ORE       = "bituminous_nether_ore";
    public static final String CINNABAR_NETHER_ORE         = "cinnabar_nether_ore";
    public static final String COPPER_NETHER_ORE           = "copper_nether_ore";
    public static final String LEAD_NETHER_ORE             = "lead_nether_ore";
    public static final String NICKEL_NETHER_ORE           = "nickel_nether_ore";
    public static final String NITER_NETHER_ORE            = "niter_nether_ore";
    public static final String OSMIUM_NETHER_ORE           = "osmium_nether_ore";
    public static final String PLATINUM_NETHER_ORE         = "platinum_nether_ore";
    public static final String RUBY_NETHER_ORE             = "ruby_nether_ore";
    public static final String SALTPETER_NETHER_ORE        = "saltpeter_nether_ore";
    public static final String SAPPHIRE_NETHER_ORE         = "sapphire_nether_ore";
    public static final String SILVER_NETHER_ORE           = "silver_nether_ore";
    public static final String SULFUR_NETHER_ORE           = "sulfur_nether_ore";
    public static final String TIN_NETHER_ORE              = "tin_nether_ore";
    public static final String URANIUM_NETHER_ORE          = "uranium_nether_ore";
    public static final String ZINC_NETHER_ORE             = "zinc_nether_ore";

    // ----------------------------------------- nether.basalt ---------------------------------------
    public static final String COAL_BASALT_ORE             = "coal_basalt_ore";
    public static final String IRON_BASALT_ORE             = "iron_basalt_ore";
    public static final String GOLD_BASALT_ORE             = "gold_basalt_ore";
    public static final String DIAMOND_BASALT_ORE          = "diamond_basalt_ore";
    public static final String EMERALD_BASALT_ORE          = "emerald_basalt_ore";
    public static final String LAPIS_BASALT_ORE            = "lapis_basalt_ore";
    public static final String REDSTONE_BASALT_ORE         = "redstone_basalt_ore";
    // --> MODDED ORE
    public static final String ALUMINIUM_BASALT_ORE        = "aluminium_basalt_ore";
    public static final String AMBER_BASALT_ORE            = "amber_basalt_ore";
    public static final String AMETHYST_BASALT_ORE         = "amethyst_basalt_ore";
    public static final String APATITE_BASALT_ORE          = "apatite_basalt_ore";
    public static final String BITUMINOUS_BASALT_ORE       = "bituminous_basalt_ore";
    public static final String CINNABAR_BASALT_ORE         = "cinnabar_basalt_ore";
    public static final String COPPER_BASALT_ORE           = "copper_basalt_ore";
    public static final String LEAD_BASALT_ORE             = "lead_basalt_ore";
    public static final String NICKEL_BASALT_ORE           = "nickel_basalt_ore";
    public static final String NITER_BASALT_ORE            = "niter_basalt_ore";
    public static final String OSMIUM_BASALT_ORE           = "osmium_basalt_ore";
    public static final String PLATINUM_BASALT_ORE         = "platinum_basalt_ore";
    public static final String RUBY_BASALT_ORE             = "ruby_basalt_ore";
    public static final String SALTPETER_BASALT_ORE        = "saltpeter_basalt_ore";
    public static final String SAPPHIRE_BASALT_ORE         = "sapphire_basalt_ore";
    public static final String SILVER_BASALT_ORE           = "silver_basalt_ore";
    public static final String SULFUR_BASALT_ORE           = "sulfur_basalt_ore";
    public static final String TIN_BASALT_ORE              = "tin_basalt_ore";
    public static final String URANIUM_BASALT_ORE          = "uranium_basalt_ore";
    public static final String ZINC_BASALT_ORE             = "zinc_basalt_ore";

    // ------------------------------------------ nether.dense ---------------------------------------
    public static final String DENSE_COAL_NETHER_ORE       = "dense_coal_nether_ore";
    public static final String DENSE_IRON_NETHER_ORE       = "dense_iron_nether_ore";
    public static final String DENSE_GOLD_NETHER_ORE       = "dense_gold_nether_ore";
    public static final String DENSE_DIAMOND_NETHER_ORE    = "dense_diamond_nether_ore";
    public static final String DENSE_EMERALD_NETHER_ORE    = "dense_emerald_nether_ore";
    public static final String DENSE_LAPIS_NETHER_ORE      = "dense_lapis_nether_ore";
    public static final String DENSE_REDSTONE_NETHER_ORE   = "dense_redstone_nether_ore";
    public static final String DENSE_QUARTZ_NETHER_ORE     = "dense_quartz_nether_ore";
    // --> MODDED ORE
    public static final String DENSE_ALUMINIUM_NETHER_ORE        = "dense_aluminium_nether_ore";
    public static final String DENSE_AMBER_NETHER_ORE            = "dense_amber_nether_ore";
    public static final String DENSE_AMETHYST_NETHER_ORE         = "dense_amethyst_nether_ore";
    public static final String DENSE_APATITE_NETHER_ORE          = "dense_apatite_nether_ore";
    public static final String DENSE_BITUMINOUS_NETHER_ORE       = "dense_bituminous_nether_ore";
    public static final String DENSE_CINNABAR_NETHER_ORE         = "dense_cinnabar_nether_ore";
    public static final String DENSE_COPPER_NETHER_ORE           = "dense_copper_nether_ore";
    public static final String DENSE_LEAD_NETHER_ORE             = "dense_lead_nether_ore";
    public static final String DENSE_NICKEL_NETHER_ORE           = "dense_nickel_nether_ore";
    public static final String DENSE_NITER_NETHER_ORE            = "dense_niter_nether_ore";
    public static final String DENSE_OSMIUM_NETHER_ORE           = "dense_osmium_nether_ore";
    public static final String DENSE_PLATINUM_NETHER_ORE         = "dense_platinum_nether_ore";
    public static final String DENSE_RUBY_NETHER_ORE             = "dense_ruby_nether_ore";
    public static final String DENSE_SALTPETER_NETHER_ORE        = "dense_saltpeter_nether_ore";
    public static final String DENSE_SAPPHIRE_NETHER_ORE         = "dense_sapphire_nether_ore";
    public static final String DENSE_SILVER_NETHER_ORE           = "dense_silver_nether_ore";
    public static final String DENSE_SULFUR_NETHER_ORE           = "dense_sulfur_nether_ore";
    public static final String DENSE_TIN_NETHER_ORE              = "dense_tin_nether_ore";
    public static final String DENSE_URANIUM_NETHER_ORE          = "dense_uranium_nether_ore";
    public static final String DENSE_ZINC_NETHER_ORE             = "dense_zinc_nether_ore";

    // ---------------------------------------------- end --------------------------------------------
    public static final String COAL_END_ORE                = "coal_end_ore";
    public static final String IRON_END_ORE                = "iron_end_ore";
    public static final String GOLD_END_ORE                = "gold_end_ore";
    public static final String DIAMOND_END_ORE             = "diamond_end_ore";
    public static final String EMERALD_END_ORE             = "emerald_end_ore";
    public static final String LAPIS_END_ORE               = "lapis_end_ore";
    public static final String REDSTONE_END_ORE            = "redstone_end_ore";
    // --> MODDED ORE
    public static final String ALUMINIUM_END_ORE        = "aluminium_end_ore";
    public static final String AMBER_END_ORE            = "amber_end_ore";
    public static final String AMETHYST_END_ORE         = "amethyst_end_ore";
    public static final String APATITE_END_ORE          = "apatite_end_ore";
    public static final String BITUMINOUS_END_ORE       = "bituminous_end_ore";
    public static final String CINNABAR_END_ORE         = "cinnabar_end_ore";
    public static final String COPPER_END_ORE           = "copper_end_ore";
    public static final String LEAD_END_ORE             = "lead_end_ore";
    public static final String NICKEL_END_ORE           = "nickel_end_ore";
    public static final String NITER_END_ORE            = "niter_end_ore";
    public static final String OSMIUM_END_ORE           = "osmium_end_ore";
    public static final String PLATINUM_END_ORE         = "platinum_end_ore";
    public static final String RUBY_END_ORE             = "ruby_end_ore";
    public static final String SALTPETER_END_ORE        = "saltpeter_end_ore";
    public static final String SAPPHIRE_END_ORE         = "sapphire_end_ore";
    public static final String SILVER_END_ORE           = "silver_end_ore";
    public static final String SULFUR_END_ORE           = "sulfur_end_ore";
    public static final String TIN_END_ORE              = "tin_end_ore";
    public static final String URANIUM_END_ORE          = "uranium_end_ore";
    public static final String ZINC_END_ORE             = "zinc_end_ore";


    // ---------------------------------------------- gems ----------------------------------------------
    // --> MODDED GEMS
    public static final String AMETHYST                    = "amethyst";
    public static final String RUBY                        = "ruby";
    public static final String SAPPHIRE                    = "sapphire";

    // --------------------------------------------- ingots ---------------------------------------------
    // --> MODDED INGOTS
    public static final String ALUMINIUM_INGOT             = "aluminium_ingot";
    public static final String COPPER_INGOT                = "copper_ingot";
    public static final String LEAD_INGOT                  = "lead_ingot";
    public static final String OSMIUM_INGOT                = "osmium_ingot";
    public static final String SILVER_INGOT                = "silver_ingot";
    public static final String TIN_INGOT                   = "tin_ingot";
    public static final String URANIUM_INGOT               = "uranium_ingot";
    public static final String ZINC_INGOT                  = "zinc_ingot";

    // ---------------------------------------------- dust ----------------------------------------------
    public static final String COAL_DUST                   = "coal_dust";
    public static final String IRON_DUST                   = "iron_dust";
    public static final String GOLD_DUST                   = "gold_dust";
    public static final String DIAMOND_DUST                = "diamond_dust";
    public static final String EMERALD_DUST                = "emerald_dust";
    public static final String LAPIS_DUST                  = "lapis_dust";
    // --> MODDED DUST
    public static final String ALUMINIUM_DUST              = "aluminium_dust";
    public static final String COPPER_DUST                 = "copper_dust";
    public static final String LEAD_DUST                   = "lead_dust";
    public static final String NICKEL_DUST                 = "nickel_dust";
    public static final String PLATINUM_DUST               = "platinum_dust";
    public static final String RUBY_DUST                   = "ruby_dust";
    public static final String SAPPHIRE_DUST               = "sapphire_dust";
    public static final String SILVER_DUST                 = "silver_dust";
    public static final String TIN_DUST                    = "tin_dust";
    public static final String URANIUM_DUST                = "uranium_dust";

    // --------------------------------------------- gears ----------------------------------------------


    // ---------------------------------------------- rods ----------------------------------------------


    // --------------------------------------------- blocks ---------------------------------------------
    // --> MODDED BLOCKS
    public static final String RUBY_BLOCK                  = "ruby_block";
    public static final String SAPPHIRE_BLOCK              = "sapphire_block";
}
