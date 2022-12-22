package io.github.rawchickenneg.com;

import io.github.rawchickenneg.com.init.BlockRegistry;
import io.github.rawchickenneg.com.init.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

@Mod(CraftOfMCreator.MOD_ID)
public class CraftOfMCreator {
    public CraftOfMCreator(){
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(CraftOfMCreator.MOD_ID)
    {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.STONE);
        }
    };
    public static final String MOD_ID = "craft_of_mcreator";
}
