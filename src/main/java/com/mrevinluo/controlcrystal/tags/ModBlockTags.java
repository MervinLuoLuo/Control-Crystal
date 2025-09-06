package com.mrevinluo.controlcrystal.tags;

import com.mrevinluo.controlcrystal.ControlCrystal;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> CRYSTAL_ORES = of("crystal_ores");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ControlCrystal.MOD_ID,id));
    }

    public static void registerModBlockTags() {
        ControlCrystal.LOGGER.info("Registering ModBlockTags");
    }
}
