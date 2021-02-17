package fr.alasdiablo.janoeo.init;

import fr.alasdiablo.janoeo.util.Registries;
import fr.alasdiablo.janoeo.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {
    public static Map<String, List<String>> ITEMS = new HashMap<String, List<String>>() {{
        put(StringUtils.cleanOreName(Registries.COAL_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.IRON_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.GOLD_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.DIAMOND_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.EMERALD_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.LAPIS_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.REDSTONE_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_gear");
            add("has_rod");
        }});
        // --> MODDED ORE
        put(StringUtils.cleanOreName(Registries.ALUMINIUM_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_nugget");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.AMETHYST_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gem");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.COPPER_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.LEAD_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.OSMIUM_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.RUBY_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gem");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.SAPPHIRE_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_gem");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.SILVER_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.TIN_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.URANIUM_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
        put(StringUtils.cleanOreName(Registries.ZINC_ORE, true).toUpperCase(), new ArrayList<String>() {{
            add("has_dust");
            add("has_ingot");
            add("has_gear");
            add("has_rod");
        }});
    }};
}
