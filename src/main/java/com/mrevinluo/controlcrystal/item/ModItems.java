package com.mrevinluo.controlcrystal.item;

import com.mrevinluo.controlcrystal.ControlCrystal;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    //四个水晶
    public static final Item BASIC_CRYSTAL = register("basic_crystal", Item::new, new Item.Settings());
    public static final Item ADVANCED_CRYSTAL = register("advanced_crystal", Item::new, new Item.Settings());
    public static final Item MORE_ADVANCED_CRYSTAL = register("more_advanced_crystal", Item::new, new Item.Settings());
    public static final Item TOP_CRYSTAL = register("top_crystal", Item::new, new Item.Settings());

    //水晶碎片
    public static final Item CRYSTAL_FRAGMENT = register("crystal_fragment", Item::new, new Item.Settings());

    //注册物品方法
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ControlCrystal.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    //初始化类

    public static void registerItems() {
    }
}
