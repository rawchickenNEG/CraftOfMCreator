package io.github.rawchickenneg.com.item;

import io.github.rawchickenneg.com.init.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemTier {
    public static final Tier MCREATORIUM= new ForgeTier(5, 99999, 10F, 10F, 30,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemRegistry.MCREATORIUM_INGOT.get()));
}