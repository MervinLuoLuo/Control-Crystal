package com.mrevinluo.controlcrystal.world;

import com.mrevinluo.controlcrystal.ControlCrystal;
import com.mrevinluo.controlcrystal.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_ORE_KEY = of("crystal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_CRYSTAL_ORE_KEY = of("deepslate_crystal_ore");

    //键值注册
    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ControlCrystal.MOD_ID, id));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {

        //替换规则
        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> crystalOreTarget = List.of(
                OreFeatureConfig.createTarget(stoneReplace, ModBlocks.CRYSTAL_ORE.getDefaultState())
//                OreFeatureConfig.createTarget(deepSlateReplace,  ModBlocks.DEEPSLATE_CRYSTAL_ORE.getDefaultState())
        );

        register(featureRegisterable, CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(crystalOreTarget,8));

        List<OreFeatureConfig.Target> deepslateOreTarget = List.of(
                OreFeatureConfig.createTarget(deepSlateReplace,  ModBlocks.DEEPSLATE_CRYSTAL_ORE.getDefaultState())
        );

        register(featureRegisterable, DEEPSLATE_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(deepslateOreTarget,8));
    }


    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        registerable.register(key, new ConfiguredFeature<FC,F>(feature, config));
    }
}
