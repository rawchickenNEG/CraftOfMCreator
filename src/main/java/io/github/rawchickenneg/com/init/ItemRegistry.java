package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.item.ItemTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftOfMCreator.MOD_ID);
    public static final RegistryObject<Item> MCREATORIUM_INGOT = ITEMS.register("mcreatorium_ingot", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_RAW = ITEMS.register("raw_mcreatorium", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_HELMET = ITEMS.register("mcreatorium_helmet", () -> new ArmorItem(ArmorTier.MCREATORIUM, EquipmentSlot.HEAD, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CHESTPLATE = ITEMS.register("mcreatorium_chestplate", () -> new ArmorItem(ArmorTier.MCREATORIUM, EquipmentSlot.CHEST, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_LEGGINGS = ITEMS.register("mcreatorium_leggings", () -> new ArmorItem(ArmorTier.MCREATORIUM, EquipmentSlot.LEGS, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_BOOTS = ITEMS.register("mcreatorium_boots", () -> new ArmorItem(ArmorTier.MCREATORIUM, EquipmentSlot.FEET, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_HOE = ITEMS.register("mcreatorium_hoe", () -> new HoeItem(ItemTier.MCREATORIUM, -5, -1.0F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_AXE = ITEMS.register("mcreatorium_axe", () -> new AxeItem(ItemTier.MCREATORIUM, 6.0F, -3.1F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_PICKAXE = ITEMS.register("mcreatorium_pickaxe", () -> new PickaxeItem(ItemTier.MCREATORIUM, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_SWORD = ITEMS.register("mcreatorium_sword", () -> new SwordItem(ItemTier.MCREATORIUM, 4, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_SHOVEL = ITEMS.register("mcreatorium_shovel", () -> new ShovelItem(ItemTier.MCREATORIUM, 1.5F, -1F, defaultBuilder()));

    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(CraftOfMCreator.CREATIVE_TAB);
    }
    
}