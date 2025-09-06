package com.mrevinluo.controlcrystal;

import com.mrevinluo.controlcrystal.block.ModBlocks;
import com.mrevinluo.controlcrystal.datagen.ModItemTagsProvider;
import com.mrevinluo.controlcrystal.datagen.ModWorldGen;
import com.mrevinluo.controlcrystal.item.CrystalsGroup;
import com.mrevinluo.controlcrystal.item.ModItems;
import com.mrevinluo.controlcrystal.tags.ModBlockTags;
import com.mrevinluo.controlcrystal.tags.ModItemTags;
import com.mrevinluo.controlcrystal.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlCrystal implements ModInitializer {
	public static final String MOD_ID = "control-crystal";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        //注册
        ModItems.registerItems();
        ModBlocks.RegCrystalOre();
        CrystalsGroup.RegItemGroup();
        ModBlockTags.registerModBlockTags();
        ModItemTags.registerModItemTags();

        //数据生成
        ModWorldGeneration.registerWorldGenerations();


		LOGGER.info("Control Crystal!!!!!");
	}
}