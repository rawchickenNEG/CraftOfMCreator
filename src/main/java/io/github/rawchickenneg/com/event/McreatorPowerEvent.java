package io.github.rawchickenneg.com.event;

import io.github.rawchickenneg.com.init.MobEffectRegisrty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class McreatorPowerEvent {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() instanceof LivingEntity livingEntity && livingEntity.hasEffect(MobEffectRegisrty.MCREATOR_POWER.get())) {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() instanceof LivingEntity livingEntity && livingEntity.hasEffect(MobEffectRegisrty.MCREATOR_POWER.get())) {
            event.setCanceled(true);
        }
    }
}
