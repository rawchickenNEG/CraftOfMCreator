package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.mobeffect.McreatorPower;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobEffectRegisrty {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CraftOfMCreator.MOD_ID);

    public static final RegistryObject<MobEffect> MCREATOR_POWER = MOB_EFFECTS.register("mcreator_power", () -> new McreatorPower(MobEffectCategory.BENEFICIAL, -13382656));
    public static final RegistryObject<MobEffect> MCREATOR_RAGE = MOB_EFFECTS.register("mcreator_rage", () -> new McreatorPower(MobEffectCategory.BENEFICIAL, -6750157));
}
