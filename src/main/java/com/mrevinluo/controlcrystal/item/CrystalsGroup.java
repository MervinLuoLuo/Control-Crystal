package com.mrevinluo.controlcrystal.item;

import com.mrevinluo.controlcrystal.ControlCrystal;
import com.mrevinluo.controlcrystal.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrystalsGroup {
    //注册物品组
    public static final RegistryKey<ItemGroup> CONTROL_CRYSTALS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(ControlCrystal.MOD_ID, "crystals_group"));
    public static final ItemGroup CONTROL_CRYSTALS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TOP_CRYSTAL))
            .displayName(Text.translatable("itemGroup.control_crystals"))
            .build();

    public static void RegItemGroup() {
        Registry.register(Registries.ITEM_GROUP, CONTROL_CRYSTALS_KEY, CONTROL_CRYSTALS);

        ItemGroupEvents.modifyEntriesEvent(CONTROL_CRYSTALS_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.BASIC_CRYSTAL);
            itemGroup.add(ModItems.ADVANCED_CRYSTAL);
            itemGroup.add(ModItems.MORE_ADVANCED_CRYSTAL);
            itemGroup.add(ModItems.TOP_CRYSTAL);
            itemGroup.add(ModItems.CRYSTAL_FRAGMENT);
            itemGroup.add(ModBlocks.CRYSTAL_ORE.asItem());
            itemGroup.add(ModBlocks.DEEPSLATE_CRYSTAL_ORE.asItem());
        });
    }
}
