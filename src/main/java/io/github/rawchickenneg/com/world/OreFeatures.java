package io.github.rawchickenneg.com.world;

import io.github.rawchickenneg.com.CraftOfMCreator;
import io.github.rawchickenneg.com.init.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

import static net.minecraft.data.worldgen.features.OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.data.worldgen.features.OreFeatures.STONE_ORE_REPLACEABLES;

@Mod.EventBusSubscriber(modid = CraftOfMCreator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreFeatures {

    static boolean alreadySetup;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> MCREATORIUM_CONFIG;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> STEEL_CONFIG;
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> BRONZE_CONFIG;

    public static Holder<PlacedFeature> MCREATORIUM;
    public static Holder<PlacedFeature> STEEL;
    public static Holder<PlacedFeature> BRONZE;
    static void setup() {
        List<OreConfiguration.TargetBlockState> mcreatoriumList =
                List.of(OreConfiguration.target(
                                STONE_ORE_REPLACEABLES,
                                BlockRegistry.MCREATORIUM_ORE.get().defaultBlockState()
                        ),
                        OreConfiguration.target(
                                DEEPSLATE_ORE_REPLACEABLES,
                                BlockRegistry.DEEPSLATE_MCREATORIUM_ORE.get().defaultBlockState()
                        ));
        List<OreConfiguration.TargetBlockState> steelList =
                List.of(OreConfiguration.target(
                                STONE_ORE_REPLACEABLES,
                                BlockRegistry.STEEL_ORE.get().defaultBlockState()
                        ),
                        OreConfiguration.target(
                                DEEPSLATE_ORE_REPLACEABLES,
                                BlockRegistry.DEEPSLATE_STEEL_ORE.get().defaultBlockState()
                        ));
        List<OreConfiguration.TargetBlockState> bronzeList =
                List.of(OreConfiguration.target(
                                STONE_ORE_REPLACEABLES,
                                BlockRegistry.BRONZE_ORE.get().defaultBlockState()
                        ),
                        OreConfiguration.target(
                                DEEPSLATE_ORE_REPLACEABLES,
                                BlockRegistry.DEEPSLATE_BRONZE_ORE.get().defaultBlockState()
                        ));
        MCREATORIUM_CONFIG = FeatureUtils.register("mcreatorium_ore", Feature.ORE,
                new OreConfiguration(mcreatoriumList, 16));
        STEEL_CONFIG = FeatureUtils.register("steel_ore", Feature.ORE,
                new OreConfiguration(steelList, 8));
        BRONZE_CONFIG = FeatureUtils.register("bronze_ore", Feature.ORE,
                new OreConfiguration(bronzeList, 7));

        MCREATORIUM = PlacementUtils.register("mcreatorium", MCREATORIUM_CONFIG,
                commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64),
                        VerticalAnchor.belowTop(5))));
        STEEL = PlacementUtils.register("steel", STEEL_CONFIG,
                commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40),
                        VerticalAnchor.belowTop(30))));
        BRONZE = PlacementUtils.register("bronze", BRONZE_CONFIG,
                commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-30),
                        VerticalAnchor.belowTop(50))));
    }

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {

        BiomeGenerationSettingsBuilder genEvent = event.getGeneration();
        ResourceKey<Biome> biomeKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName()));

        if (BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.OVERWORLD)) {

            if(!alreadySetup) {
                setup();
                alreadySetup = true;
            }
            genEvent.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MCREATORIUM);
            genEvent.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, STEEL);
            genEvent.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BRONZE);

        }
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

}
