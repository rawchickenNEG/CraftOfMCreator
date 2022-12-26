package io.github.rawchickenneg.com.item;

import com.google.common.collect.Lists;
import io.github.rawchickenneg.com.init.ItemRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;

public class McreatoriumArmor extends ArmorItem {
    public McreatoriumArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
    }
    @Override
    public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
        if (entity.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistry.MCREATORIUM_HELMET.get())) {
            entity.setAirSupply(entity.getMaxAirSupply());
            entity.getFoodData().setFoodLevel(20);
            entity.getFoodData().setSaturation(20);
        }
        if (entity.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.MCREATORIUM_CHESTPLATE.get())) {
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, true, true, true));
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0, true, true, true));
            entity.clearFire();
        }
        if (entity.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistry.MCREATORIUM_LEGGINGS.get())) {
            List<MobEffectInstance> effects = Lists.newArrayList(entity.getActiveEffects());
            for (MobEffectInstance effectInstance : effects) {
                MobEffect effect = effectInstance.getEffect();
                if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                    entity.removeEffect(effect);
                }
            }
        }
        if (entity.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistry.MCREATORIUM_BOOTS.get())) {
            entity.fallDistance = 0;
        }
        if (!entity.isCreative() && !entity.isSpectator()) {
            if (entity.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistry.MCREATORIUM_HELMET.get()) && entity.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistry.MCREATORIUM_LEGGINGS.get()) && entity.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistry.MCREATORIUM_BOOTS.get()) && entity.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.MCREATORIUM_CHESTPLATE.get())) {
                entity.getAbilities().mayfly = true;
                entity.onUpdateAbilities();
            } else {
                entity.getAbilities().mayfly = false;
                entity.getAbilities().flying = false;
                entity.onUpdateAbilities();
            }
        }
    }
}

