package fr.alasdiablo.janoeo.block;

import fr.alasdiablo.diolib.block.IEndOre;
import fr.alasdiablo.diolib.block.INetherOre;
import fr.alasdiablo.diolib.generic.ExperienceRarity;
import fr.alasdiablo.diolib.generic.IDropExperience;
import fr.alasdiablo.janoeo.Janoeo;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import java.util.Random;

/**
 * Default implementation of Ore blocks
 */
public class BasicOre extends OreBlock implements IForgeBlock, INetherOre, IEndOre, IDropExperience {

    /**
     * Variable use of store ExperienceRarity needed by IDropExperience
     */
    private ExperienceRarity experienceRarity;

    private boolean angersEnderman;
    private boolean angersZombifiedPiglin;

    private  void setDefaults(String registryName, String harvestAngers, ExperienceRarity experienceRarity) {
        this.setRegistryName(registryName);

        // Should This Anger Mob
        this.angersZombifiedPiglin = harvestAngers.toUpperCase() == "ZOMBIFIED_PIGLIN" || harvestAngers.toUpperCase() == "ZOMBIFIED_PIGLIN_&_ENDERMAN";
        this.angersEnderman = harvestAngers.toUpperCase() == "ENDERMAN" || harvestAngers.toUpperCase() == "ZOMBIFIED_PIGLIN_&_ENDERMAN";

        // Set Experience Rarity
        this.experienceRarity = experienceRarity;
    }


    /**
     * Default constructor
     *
     * @param registryName     Name of the block
     * @param material         Type of Material Ore is Made of
     * @param soundType        Sound to be played
     * @param hardness         Time to break block
     * @param resistance       Resistance of Explosion Damage
     * @param harvestLevel     Tool Level Required to Mine
     * @param toolType         Tool Required to mine Ore
     * @param harvestAngers    What does harvesting this ore anger
     * @param experienceRarity ExperienceRarity of the block
     */
    public BasicOre(String registryName, Material material, SoundType soundType, float hardness, float resistance, int harvestLevel, ToolType toolType, String harvestAngers, ExperienceRarity experienceRarity) {
        super(Properties.create(material)
                .sound(soundType)
                .hardnessAndResistance(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(toolType)
                .setRequiresTool()
        );
        setDefaults(registryName, harvestAngers, experienceRarity);
    }

    // --------------------------------------- CORE REGISTRIES --------------------------------------
    // -------------------------------------- NO MATERIAL/SOUND -------------------------------------
    public BasicOre(String registryName, float hardness, float resistance, int harvestLevel, ToolType toolType, String harvestAngers, ExperienceRarity experienceRarity) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(toolType)
                .setRequiresTool()
        );
        setDefaults(registryName, harvestAngers, experienceRarity);
    }
    // --> JOINED HARDNESS AND RESISTANCE
    public BasicOre(String registryName, float hardnessAndresistance, int harvestLevel, ToolType toolType, String harvestAngers, ExperienceRarity experienceRarity) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(hardnessAndresistance)
                .harvestLevel(harvestLevel)
                .harvestTool(toolType)
                .setRequiresTool()
        );
        setDefaults(registryName, harvestAngers, experienceRarity);
    }


    // --------------------------------------- LEAST REQUIRED ---------------------------------------
    public BasicOre(String registryName, float hardness, float resistance, int harvestLevel, String harvestAngers, ExperienceRarity experienceRarity) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
        setDefaults(registryName, harvestAngers, experienceRarity);
    }
    public BasicOre(String registryName, float hardness, float resistance, int harvestLevel, ExperienceRarity experienceRarity) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
        setDefaults(registryName, "NOTHING", experienceRarity);
    }
    public BasicOre(String registryName, float hardness, float resistance, int harvestLevel) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
        setDefaults(registryName, "NOTHING", ExperienceRarity.NULL);
    }
    public BasicOre(String registryName, int harvestLevel, ExperienceRarity experienceRarity) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0f)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
        setDefaults(registryName, "NOTHING", experienceRarity);
    }
    public BasicOre(String registryName, int harvestLevel) {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0f)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
        );
        setDefaults(registryName, "NOTHING", ExperienceRarity.NULL);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBlockHarvested(worldIn, pos, state, player);

        Janoeo.logger.debug("onBlockHarvested: " + this.getAngersZombifiedPiglin() + " || " + this.getAngersEnderman());

        if (this.getAngersZombifiedPiglin()) {
            this.angerZombifiedPiglin(player, worldIn, pos, null, null);
        }

        if (this.getAngersEnderman()) {
            this.angerEnderman(player, worldIn, pos, null, null);
        }
    }

    public boolean getAngersZombifiedPiglin() {
        return angersZombifiedPiglin;
    }

    public boolean getAngersEnderman() {
        return angersEnderman;
    }

    /**
     * Rewrite <i>getExperience</i> for make it compatible with <i>IDropExperience</i>
     *
     * @see fr.alasdiablo.diolib.generic.IDropExperience
     * @see net.minecraft.block.OreBlock
     */
    @Override
    protected int getExperience(Random random) {
        int experience = this.getExperience(random, this);
        return experience != -1 ? experience : super.getExperience(random);
    }

    /**
     * Implement getter of <i>IDropExperience</i>
     *
     * @see fr.alasdiablo.diolib.generic.IDropExperience
     */
    @Override
    public ExperienceRarity getExperienceRarity() {
        return this.experienceRarity;
    }
}
