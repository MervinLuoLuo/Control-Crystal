package com.mrevinluo.controlcrystal.datagen;

import com.mrevinluo.controlcrystal.block.ModBlocks;
import com.mrevinluo.controlcrystal.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE);

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE);

        valueLookupBuilder(ModBlockTags.CRYSTAL_ORES)
                .add(ModBlocks.CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_CRYSTAL_ORE);
    }
}
