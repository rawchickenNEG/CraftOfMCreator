package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.block.CommonBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CraftOfMCreator.MOD_ID);
    public static final RegistryObject<Block> CLAY_BLOCK = BLOCKS.register("clay_block", () -> {
        return new CommonBlocks(Block.Properties.of(Material.METAL).strength(3.0F, 10F).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK));
    });
}




