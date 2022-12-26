package io.github.rawchickenneg.com.item;

import io.github.rawchickenneg.com.init.ItemRegistry;
import io.github.rawchickenneg.com.init.MobEffectRegisrty;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class McreatorExecutor extends SwordItem {
    public McreatorExecutor(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        boolean result = super.hurtEnemy(p_43278_, p_43279_, p_43280_);
        if (result) {
            p_43279_.setHealth(0);
            if (p_43279_.getHealth() <= 0){
                p_43279_.die(Objects.requireNonNull(p_43279_.getLastDamageSource()));
            }
        }
        return result;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, level, entity, slot, selected);
        if (entity instanceof LivingEntity livingEntity){
            if (livingEntity.getOffhandItem().is(ItemRegistry.THE_ULTIMATE_MCREATOR_EXECUTOR.get()) || selected){
                livingEntity.addEffect(new MobEffectInstance(MobEffectRegisrty.MCREATOR_POWER.get(), 5, 0, true, true, true));
            }
        }
    }

}
