package com.mrevinluo.controlcrystal;

import com.mrevinluo.controlcrystal.datagen.ModLootTableProvider;
import com.mrevinluo.controlcrystal.datagen.ModWorldGen;
import com.mrevinluo.controlcrystal.world.ModConfiguredFeatures;
import com.mrevinluo.controlcrystal.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ControlCrystalDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

//        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModWorldGen::new);
	}

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
