package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.item.ItemTier;
import io.github.rawchickenneg.com.item.McreatorExecutor;
import io.github.rawchickenneg.com.item.McreatorExecutorDark;
import io.github.rawchickenneg.com.item.McreatoriumArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CraftOfMCreator.MOD_ID);
    public static final RegistryObject<Item> MCREATORIUM_BLOCK = ITEMS.register("mcreatorium_block", () -> new ItemNameBlockItem(BlockRegistry.MCREATORIUM_BLOCK.get(), defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_ORE = ITEMS.register("mcreatorium_ore", () -> new ItemNameBlockItem(BlockRegistry.MCREATORIUM_ORE.get(), defaultBuilder()));
    public static final RegistryObject<Item> DEEPSLATE_MCREATORIUM_ORE = ITEMS.register("deepslate_mcreatorium_ore", () -> new ItemNameBlockItem(BlockRegistry.DEEPSLATE_MCREATORIUM_ORE.get(), defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_INGOT = ITEMS.register("mcreatorium_ingot", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_RAW = ITEMS.register("raw_mcreatorium", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_HELMET = ITEMS.register("mcreatorium_helmet", () -> new McreatoriumArmor(ArmorTier.MCREATORIUM, EquipmentSlot.HEAD, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CHESTPLATE = ITEMS.register("mcreatorium_chestplate", () -> new McreatoriumArmor(ArmorTier.MCREATORIUM, EquipmentSlot.CHEST, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_LEGGINGS = ITEMS.register("mcreatorium_leggings", () -> new McreatoriumArmor(ArmorTier.MCREATORIUM, EquipmentSlot.LEGS, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_BOOTS = ITEMS.register("mcreatorium_boots", () -> new McreatoriumArmor(ArmorTier.MCREATORIUM, EquipmentSlot.FEET, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_HOE = ITEMS.register("mcreatorium_hoe", () -> new HoeItem(ItemTier.MCREATORIUM, -5, -1.0F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_AXE = ITEMS.register("mcreatorium_axe", () -> new AxeItem(ItemTier.MCREATORIUM, 6.0F, -3.1F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_PICKAXE = ITEMS.register("mcreatorium_pickaxe", () -> new PickaxeItem(ItemTier.MCREATORIUM, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_SWORD = ITEMS.register("mcreatorium_sword", () -> new SwordItem(ItemTier.MCREATORIUM, 4, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_SHOVEL = ITEMS.register("mcreatorium_shovel", () -> new ShovelItem(ItemTier.MCREATORIUM, 1.5F, -1F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE = ITEMS.register("mcreatorium_core", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_ADVANCED = ITEMS.register("mcreatorium_core_advanced", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_SUPER = ITEMS.register("mcreatorium_core_super", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_ULTIMATE = ITEMS.register("mcreatorium_core_ultimate", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_EXTREME = ITEMS.register("mcreatorium_core_extreme", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_RAINBOW = ITEMS.register("mcreatorium_core_rainbow", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_INVINCIBLE = ITEMS.register("mcreatorium_core_invincible", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MCREATORIUM_CORE_BEYOND = ITEMS.register("mcreatorium_core_beyond", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> THE_ULTIMATE_MCREATOR_EXECUTOR = ITEMS.register("the_ultimate_mcreator_executor", () -> new McreatorExecutor(ItemTier.MCREATORIUM, 4, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> THE_ULTIMATE_MCREATOR_EXECUTOR_DARK = ITEMS.register("the_ultimate_mcreator_executor_dark", () -> new McreatorExecutorDark(ItemTier.MCREATORIUM, 4, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> MCREATOR_LOGO = ITEMS.register("mcreator_logo", () -> new Item(new Item.Properties()));

    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(CraftOfMCreator.CREATIVE_TAB);
    }
    
}