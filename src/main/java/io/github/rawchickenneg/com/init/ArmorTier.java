package io.github.rawchickenneg.com.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArmorTier implements ArmorMaterial {
    MCREATORIUM("mcreatorium", 99999, new int[]{6, 12, 16, 6}, 100, SoundEvents.ARMOR_EQUIP_NETHERITE, 10.0F, 1.0F, () -> {
        return Ingredient.of(ItemRegistry.MCREATORIUM_INGOT.get());
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{1, 1, 1, 1};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ArmorTier(String name, int durability, int[] protection, int enchantment, SoundEvent sound, float toughness, float knockback_resistance, Supplier<Ingredient> p_40481_) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = protection;
        this.enchantmentValue = enchantment;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockback_resistance;
        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    }
