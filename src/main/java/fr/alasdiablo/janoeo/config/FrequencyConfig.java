package fr.alasdiablo.janoeo.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Add documentation
 */
public class FrequencyConfig {

    // TODO: Add all generation here (no more hard coded)

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final Config CONFIG;

    static {
        Pair<Config, ForgeConfigSpec> configPair = new ForgeConfigSpec.Builder().configure(Config::new);
        CONFIG_SPEC = configPair.getRight();
        CONFIG = configPair.getLeft();
    }

    public static class Config {

        public final Map<String, HashMap<String, HashMap<String, IntValue>>> ORE_FREQUENCY = new HashMap<String, HashMap<String, HashMap<String, IntValue>>>();
        public final int sizeMin = 1, sizeAverage = 10, sizeMax = 128, countMin = 0, countAverage = 12, countMax = 128, worldMin = 1, worldMax = 255, factorMin = 1, factorMax = 32;

        public Config(ForgeConfigSpec.Builder builder) {
            builder.comment("Ore frequency and height config for janoeo").push("janoeo");

            //final int sizeMin = 1, sizeMax = 128, countMin = 0, countMax = 128, worldMin = 1, worldMax = 255, factorMin = 1, factorMax = 32;
            ORE_FREQUENCY.put("COAL_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.coal.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.coal.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.coal.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.coal.factor", 18, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("IRON_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.iron.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.iron.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.iron.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.iron.factor", 10, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("GOLD_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.gold.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.gold.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.gold.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.gold.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("DIAMOND_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.diamond.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.diamond.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.diamond.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.diamond.factor", 3, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("EMERALD_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.emerald.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.emerald.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.emerald.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.emerald.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("LAPIS_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.lapis.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.lapis.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.lapis.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.lapis.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("REDSTONE_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.redstone.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.redstone.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.redstone.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.redstone.factor", 3, factorMin, factorMax));
                }});
            }});


            ORE_FREQUENCY.put("ALUMINIUM_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.aluminium.size", 12, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.aluminium.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.aluminium.top", 63, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.aluminium.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.aluminium.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.aluminium.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.aluminium.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.aluminium.factor", 10, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("AMETHYST_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.amethyst.size", 2, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.amethyst.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.amethyst.top", 26, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.amethyst.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.amethyst.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.amethyst.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.amethyst.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.amethyst.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("COPPER_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.copper.size", 12, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.copper.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.copper.top", 63, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.copper.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.copper.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.copper.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.copper.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.copper.factor", 10, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("LEAD_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.lead.size", 12, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.lead.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.lead.top", 63,worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.lead.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.lead.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.lead.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.lead.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.lead.factor", 10, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("OSMIUM_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.osmium.size", 4, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.osmium.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.osmium.top", 32, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.osmium.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.osmium.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.osmium.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.osmium.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.osmium.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("RUBY_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.ruby.size", 2, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.ruby.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.ruby.top", 26, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.ruby.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.ruby.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.ruby.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.ruby.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.ruby.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("SAPPHIRE_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.sapphire.size", 2, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.sapphire.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.sapphire.top", 26, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.sapphire.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.sapphire.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.sapphire.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.sapphire.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.sapphire.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("SILVER_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.silver.size", 4, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.silver.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.silver.top", 26, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.silver.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.silver.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.silver.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.silver.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.silver.factor", 6, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("TIN_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.tin.size", 8, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.tin.count", 12, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.tin.top", 63, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.tin.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.tin.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.tin.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.tin.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.tin.factor", 10, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("URANIUM_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.uranium.size", 4, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.uranium.count", 12, sizeMin, sizeMax));
                    put("TOP",      builder.defineInRange("overworld.stone.uranium.top", 32, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.uranium.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.uranium.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.uranium.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.uranium.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.uranium.factor", 3, factorMin, factorMax));
                }});
            }});

            ORE_FREQUENCY.put("ZINC_ORE", new HashMap<String, HashMap<String, IntValue>>() {{
                put("OVERWORLD.STONE", new HashMap<String, IntValue>() {{
                    put("SIZE",     builder.defineInRange("overworld.stone.zinc.size", 8, sizeMin, sizeMax));
                    put("COUNT",    builder.defineInRange("overworld.stone.zinc.count", 12, sizeMin, sizeMax));
                    put("TOP",      builder.defineInRange("overworld.stone.zinc.top", 63, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.zinc.bottom", 1, worldMin, worldMax));
                }});
                put("OVERWORLD.STONE.DENSE", new HashMap<String, IntValue>() {{
                    put("COUNT",   builder.defineInRange("overworld.stone.dense.zinc.count", 128, countMin, countMax));
                    put("TOP",      builder.defineInRange("overworld.stone.dense.zinc.top", worldMax, worldMin, worldMax));
                    put("BOTTOM",   builder.defineInRange("overworld.stone.dense.zinc.bottom", worldMin, worldMin, worldMax));
                    put("FACTOR",   builder.defineInRange("overworld.stone.dense.zinc.factor", 10, factorMin, factorMax));
                }});
            }});

            builder.pop();
        }
    }
}
