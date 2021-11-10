package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoteMobs.MOD_ID);

    public static final RegistryObject<BlockItem> COPPER_BUTTON_ITEM = ItemRegistry.ITEMS.register("copper_button", () -> new BlockItem(Registry.COPPER_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> EXPOSED_BUTTON_ITEM = ItemRegistry.ITEMS.register("exposed_button", () -> new BlockItem(Registry.EXPOSED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> OXIDISED_BUTTON_ITEM = ItemRegistry.ITEMS.register("oxidized_button", () -> new BlockItem(Registry.OXIDIZED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WEATHERED_BUTTON_ITEM = ItemRegistry.ITEMS.register("weathered_button", () -> new BlockItem(Registry.WEATHERED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> WAXED_COPPER_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_copper_button", () -> new BlockItem(Registry.WAXED_COPPER_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_exposed_button", () -> new BlockItem(Registry.WAXED_EXPOSED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_OXIDISED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_oxidized_button", () -> new BlockItem(Registry.WAXED_OXIDIZED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_weathered_button", () -> new BlockItem(Registry.WAXED_WEATHERED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<ForgeSpawnEggItem> ALLAY_SPAWN = ItemRegistry.ITEMS.register("allay_spawn_egg", () -> new ForgeSpawnEggItem(Registry.ALLAY, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> GLARE_SPAWN_EGG = ItemRegistry.ITEMS.register("glare_spawn_egg", () -> new ForgeSpawnEggItem(Registry.GLARE, 0x00b300, 0xffa500, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> DEEP_SEA_MONSTER_SPAWN_EGG = ItemRegistry.ITEMS.register("deep_sea_monster_spawn_egg", () -> new ForgeSpawnEggItem(Registry.DEEPSEAMONSTER, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> ETERNAL_HUNGER_SPAWN_EGG = ItemRegistry.ITEMS.register("eternal_hunger_spawn_egg", () -> new ForgeSpawnEggItem(Registry.ETERNALHUNGER, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> FIREFLY_SPAWN_EGG = ItemRegistry.ITEMS.register("firefly_spawn_egg", () -> new ForgeSpawnEggItem(Registry.FIREFLY, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> INFERNO_SPAWN_EGG = ItemRegistry.ITEMS.register("inferno_spawn_egg", () -> new ForgeSpawnEggItem(Registry.INFERNO, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> MEERKAT_SPAWN_EGG = ItemRegistry.ITEMS.register("meerkat_spawn_egg", () -> new ForgeSpawnEggItem(Registry.MEERKAT, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> MOOBLOOM_SPAWN_EGG = ItemRegistry.ITEMS.register("moobloom_spawn_egg", () -> new ForgeSpawnEggItem(Registry.MOOBLOOM, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> OSTRICH_SPAWN_EGG = ItemRegistry.ITEMS.register("ostrich_spawn_egg", () -> new ForgeSpawnEggItem(Registry.OSTRICH, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TRMITE_SPAWN_EGG = ItemRegistry.ITEMS.register("termite_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TERMITE, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TUMBLEWEES_SPAWN_EGG = ItemRegistry.ITEMS.register("tumbleweed_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TUMBLEWEED, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> VULTURE_SPAWN = ItemRegistry.ITEMS.register("vulture_spawn_egg", () -> new ForgeSpawnEggItem(Registry.VULTURE, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<ForgeSpawnEggItem> BAOBAB_BOAT = ItemRegistry.ITEMS.register("baobab_boat", () -> new BoatItem(Registry.BAOBABBOAT.get()));

    public static void register(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
