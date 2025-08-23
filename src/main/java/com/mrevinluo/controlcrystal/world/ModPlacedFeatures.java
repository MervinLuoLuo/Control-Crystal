package com.mrevinluo.controlcrystal.world;

import com.mrevinluo.controlcrystal.ControlCrystal;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> CRYSTAL_ORE_PLACED_KEY = of("crystal_ore");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_ORE_PLACED_KEY = of("deepslate_crystal_ore");

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ControlCrystal.MOD_ID,id));
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //水晶矿石
        register(featureRegisterable, CRYSTAL_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.CRYSTAL_ORE_KEY),
            ModOrePlacements.modifiersWithCount(20,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(72))));

        //深层水晶矿石
        register(featureRegisterable, DEEPSLATE_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_CRYSTAL_ORE_KEY),
                ModOrePlacements.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-63), YOffset.fixed(15)))
                );
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }

}
