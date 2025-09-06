package com.mrevinluo.controlcrystal.datagen;

import com.mrevinluo.controlcrystal.item.ModItems;
import com.mrevinluo.controlcrystal.tags.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItemTags.CRYSTALS)
                .add(ModItems.BASIC_CRYSTAL)
                .add(ModItems.ADVANCED_CRYSTAL)
                .add(ModItems.MORE_ADVANCED_CRYSTAL)
                .add(ModItems.TOP_CRYSTAL);
    }
}
