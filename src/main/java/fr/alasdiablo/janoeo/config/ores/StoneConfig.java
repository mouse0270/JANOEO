package fr.alasdiablo.janoeo.config.ores;

import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

import static fr.alasdiablo.janoeo.util.StringUtils.formatString;

public class StoneConfig {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final StoneConfig.Config CONFIG;

    static {
        Pair<StoneConfig.Config, ForgeConfigSpec> configPair = new ForgeConfigSpec.Builder().configure(StoneConfig.Config::new);
        CONFIG_SPEC = configPair.getRight();
        CONFIG = configPair.getLeft();
    }

    public static class Config {
        public Map<String, ForgeConfigSpec.BooleanValue> OPTIONS = new HashMap<String, ForgeConfigSpec.BooleanValue>();

        public Config(ForgeConfigSpec.Builder builder) {
            builder.comment("Stone Ore config for janoeo").push("janoeo.stone");

            for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET IS ENABLED
                Boolean isEnabled = ORE.getValue().getIsEnabled();

                OPTIONS.put(oreName, builder.comment(formatString(oreName) + " Generation? Enabled / Disabled").define(formatString(oreName, true) + "Gen", true));
            }

            builder.comment("Stone Dense Ore config for janoeo");

            for (Map.Entry<String, OreBlockProperties> ORE : StoneDense.ORES.entrySet()) {
                // GET ORE KEY NAME
                String oreName = ORE.getKey();
                // GET IS ENABLED
                Boolean isEnabled = ORE.getValue().getIsEnabled();

                OPTIONS.put("DENSE_" + oreName, builder.comment("Dense " + formatString(oreName) + " Generation? Enabled / Disabled").define(formatString("DENSE_" + oreName, true) + "Gen", true));
            }

            builder.pop();
        }
    }
}
