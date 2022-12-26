package io.github.rawchickenneg.com.event;

import io.github.rawchickenneg.com.init.MobEffectRegisrty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class McreatorRageEvent {
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null && event.getEntity() instanceof LivingEntity livingEntity && livingEntity.hasEffect(MobEffectRegisrty.MCREATOR_RAGE.get())) {
            if (event.getSource().getEntity() instanceof LivingEntity source){
                source.hurt(DamageSource.playerAttack((Player) event.getEntity()), 9999);
            }
        }
    }
}
