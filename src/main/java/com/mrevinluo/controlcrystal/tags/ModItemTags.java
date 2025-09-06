package com.mrevinluo.controlcrystal.tags;

import com.mrevinluo.controlcrystal.ControlCrystal;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> CRYSTALS = of("crystals");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(ControlCrystal.MOD_ID,id));
    }

    public static void registerModItemTags() {
        ControlCrystal.LOGGER.info("Registering ModItemTags");
    }
}
