package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
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

    public static final RegistryObject<ForgeSpawnEggItem> GLARE_SPAWN_EGG = ItemRegistry.ITEMS.register("glare_spawn_egg", () -> new ForgeSpawnEggItem(Registry.GLARE, 0x00b300, 0xffa500, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> ALLAY_SPAWN = ItemRegistry.ITEMS.register("allay_spawn_egg", () -> new ForgeSpawnEggItem(Registry.ALLAY, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
