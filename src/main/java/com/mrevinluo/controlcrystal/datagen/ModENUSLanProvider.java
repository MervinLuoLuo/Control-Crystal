package com.mrevinluo.controlcrystal.datagen;

import com.mrevinluo.controlcrystal.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    protected ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BASIC_CRYSTAL,"Basic Crystal");
        translationBuilder.add(ModItems.ADVANCED_CRYSTAL,"Advanced Crystal");
        translationBuilder.add(ModItems.MORE_ADVANCED_CRYSTAL,"More Advanced Crystal");
        translationBuilder.add(ModItems.TOP_CRYSTAL,"Top Crystal");

        translationBuilder.add("itemGroup.control_crystals","Control Crystals");
    }
}
