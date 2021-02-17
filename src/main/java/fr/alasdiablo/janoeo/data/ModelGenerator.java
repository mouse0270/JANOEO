package fr.alasdiablo.janoeo.data;

import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.init.ores.Sand;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;
import fr.alasdiablo.janoeo.util.StringUtils;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Locale;
import java.util.Map;

public class ModelGenerator extends ItemModelProvider {
    public ModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Registries.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
            builder("stone", ORE.getKey().toLowerCase());
        }
        for (Map.Entry<String, OreBlockProperties> ORE : StoneDense.ORES.entrySet()) {
            builder("stone", "dense", ORE.getKey().toLowerCase());
        }
        for (Map.Entry<String, OreBlockProperties> ORE : Sand.ORES.entrySet()) {
            builder("sand", ORE.getKey().toLowerCase());
        }
    }

    private ItemModelBuilder builder(String baseBlock, String subFolder, String oreName) {
        try {
            return getBuilder(Registries.registryName(oreName, baseBlock, subFolder)).parent(getExistingFile(mcLoc("janoeo:block/ores/generic_ore")))
                    .texture("block", "minecraft:block/" + baseBlock)
                    .texture("overlay", "janoeo:block/overlays/" + subFolder + "/" + StringUtils.cleanOreName(oreName, true));
        }catch (Exception ex) {
            Janoeo.logger.debug("ITEM GENERATOR EXCEPTION: " + ex);
            return null;
        }
    }

    private ItemModelBuilder builder(String baseBlock, String oreName) {
        try {
            return getBuilder(Registries.registryName(oreName, baseBlock, null)).parent(getExistingFile(mcLoc("janoeo:block/ores/generic_ore")))
                    .texture("block", "minecraft:block/" + baseBlock)
                    .texture("overlay", "janoeo:block/overlays/" + StringUtils.cleanOreName(oreName, true));
        }catch (Exception ex) {
            Janoeo.logger.debug("ITEM GENERATOR EXCEPTION: " + ex);
            return null;
        }
    }
}
