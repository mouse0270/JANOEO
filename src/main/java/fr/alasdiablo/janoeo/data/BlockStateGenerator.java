package fr.alasdiablo.janoeo.data;

import fr.alasdiablo.janoeo.Janoeo;
import fr.alasdiablo.janoeo.init.ores.Sand;
import fr.alasdiablo.janoeo.init.ores.Stone;
import fr.alasdiablo.janoeo.init.ores.StoneDense;
import fr.alasdiablo.janoeo.util.OreBlockProperties;
import fr.alasdiablo.janoeo.util.Registries;

import fr.alasdiablo.janoeo.util.StringUtils;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, Registries.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Map.Entry<String, OreBlockProperties> ORE : Stone.ORES.entrySet()) {
            buildModelAndState(ORE.getValue().getBlock(), "stone", ORE.getKey());
        }
        for (Map.Entry<String, OreBlockProperties> ORE : StoneDense.ORES.entrySet()) {
            buildModelAndState(ORE.getValue().getBlock(), "stone", ORE.getKey(), "dense");
        }
        for (Map.Entry<String, OreBlockProperties> ORE : Sand.ORES.entrySet()) {
            buildModelAndState(ORE.getValue().getBlock(), "sand", ORE.getKey());
        }
    }

    private void buildModelAndState(Block block, String blockTexture, String particleTexture, String overlayTexture, String modelPath) {
        try {
            getVariantBuilder(block).forAllStates(state -> {
                return ConfiguredModel.builder().modelFile(models().withExistingParent(modelPath, mcLoc(Registries.MODID + ":block/ores/generic_ore"))).build();
            });
        }catch (Exception ex) {
            Janoeo.logger.debug("BLOCKSTATE GENERATOR EXCEPTION: " + ex);
        }

        try {
            models().withExistingParent(modelPath, mcLoc(Registries.MODID + ":block/ores/generic_ore"))
                    .texture("block", blockTexture)
                    .texture("particle", particleTexture)
                    .texture("overlay", overlayTexture);
        }catch (Exception ex) {
            Janoeo.logger.debug("MODEL GENERATOR EXCEPTION: " + ex);
        }
    }

    private void buildModelAndState(Block block, String mcBlock, String oreKey, String subfolder) {
        String blockTexture = "minecraft:block/" + mcBlock;
        String particleTexture = "minecraft:block/" + mcBlock;
        String overlayTexture = Registries.MODID + ":block/overlays/" + subfolder + "/" + StringUtils.cleanOreName(oreKey, true).toLowerCase();
        String modelPath = Registries.MODID + ":block/ores/" + mcBlock + "/" + subfolder + "/" + oreKey.toLowerCase();

        buildModelAndState(block, blockTexture, particleTexture, overlayTexture, modelPath);
    }

    private void buildModelAndState(Block block, String mcBlock, String oreKey) {
        String blockTexture = "minecraft:block/" + mcBlock;
        String particleTexture = "minecraft:block/" + mcBlock;
        String overlayTexture = Registries.MODID + ":block/overlays/" + StringUtils.cleanOreName(oreKey, true).toLowerCase();
        String modelPath = Registries.MODID + ":block/ores/" + mcBlock + "/" + oreKey.toLowerCase();

        buildModelAndState(block, blockTexture, particleTexture, overlayTexture, modelPath);
    }
}
