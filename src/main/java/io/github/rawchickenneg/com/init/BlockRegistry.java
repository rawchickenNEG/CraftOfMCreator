package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.block.CommonBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CraftOfMCreator.MOD_ID);
    public static final RegistryObject<Block> MCREATORIUM_BLOCK = BLOCKS.register("mcreatorium_block", () -> {
        return new CommonBlocks(Block.Properties.of(Material.METAL).strength(5.0F, 6F).requiresCorrectToolForDrops().sound(SoundType.METAL));
    });
    public static final RegistryObject<Block> MCREATORIUM_ORE = BLOCKS.register("mcreatorium_ore", () -> {
        return new Block(Block.Properties.of(Material.METAL).strength(2.0F, 6F).requiresCorrectToolForDrops().sound(SoundType.METAL));
    });
    public static final RegistryObject<Block> DEEPSLATE_MCREATORIUM_ORE = BLOCKS.register("deepslate_mcreatorium_ore", () -> {
        return new Block(Block.Properties.of(Material.METAL).strength(3.0F, 6F).requiresCorrectToolForDrops().sound(SoundType.METAL));
    });
}




