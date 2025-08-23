package com.mrevinluo.controlcrystal.datagen;

import com.mrevinluo.controlcrystal.block.ModBlocks;
import com.mrevinluo.controlcrystal.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CRYSTAL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BASIC_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADVANCED_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MORE_ADVANCED_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOP_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_FRAGMENT, Models.GENERATED);
    }
}
