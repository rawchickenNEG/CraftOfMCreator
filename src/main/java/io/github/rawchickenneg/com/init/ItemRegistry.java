package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftOfMCreator.MOD_ID);
    public static final RegistryObject<Item> CLAY_INGOT = ITEMS.register("clay_ingot", () -> new Item(defaultBuilder().rarity(Rarity.RARE)));
    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(CraftOfMCreator.CREATIVE_TAB);
    }
    
}