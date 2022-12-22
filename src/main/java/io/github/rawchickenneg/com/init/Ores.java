package io.github.rawchickenneg.com.init;

import io.github.rawchickenneg.com.CraftOfMCreator;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(CraftOfMCreator.MOD_ID)
public class Ores {
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> MY_ORE_FEATURE;
    public static Holder<PlacedFeature> MY_ORE;
    public Ores() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Ores::setup);
        MinecraftForge.EVENT_BUS.addListener(Ores::biomeLoading);
    }
    public static void registerFeatures() {
        MY_ORE_FEATURE = FeatureUtils.register(
                "craft_of_mcreator:mcreatorium_ore",
                Feature.ORE,
                new OreConfiguration(
                        OreFeatures.STONE_ORE_REPLACEABLES,
                        BlockRegistry.MCREATORIUM_ORE.get().defaultBlockState(), 60));
        MY_ORE = PlacementUtils.register(
                "craft_of_mcreator:mcreatorium_ore",
                MY_ORE_FEATURE,
                List.of(CountPlacement.of(30),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.bottom(),
                                VerticalAnchor.top())));
    }
    public static void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(Ores::registerFeatures);
    }
    public static void biomeLoading(BiomeLoadingEvent event) {
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MY_ORE);
    }
}