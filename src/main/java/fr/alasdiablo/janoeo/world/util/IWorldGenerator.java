package fr.alasdiablo.janoeo.world.util;

import fr.alasdiablo.janoeo.util.OreBlockProperties;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

public interface IWorldGenerator {
    void startWorldGeneration(Biome var1,
                              Map<String, ForgeConfigSpec.BooleanValue> var2,   // Config
                              @Nullable Map<String, OreBlockProperties> var3,   // Ores
                              @Nullable Map<String, OreBlockProperties> var4,   // Dense Ores
                              String var5,                                      // Frequency Type
                              @Nullable String var6);                           // Prefix
}
