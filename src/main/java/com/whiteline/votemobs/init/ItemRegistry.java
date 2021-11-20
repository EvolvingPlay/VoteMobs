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
    public static final RegistryObject<BlockItem> BAOBAB_BUTTON_ITEM = ItemRegistry.ITEMS.register("baobab_button", () -> new BlockItem(Registry.BAOBAB_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_BUTTON_ITEM = ItemRegistry.ITEMS.register("palm_button", () -> new BlockItem(Registry.PALM_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<BlockItem> BAOBAB_DOOR_ITEM = ItemRegistry.ITEMS.register("baobab_door", () -> new BlockItem(Registry.BAOBAB_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_DOOR_ITEM = ItemRegistry.ITEMS.register("palm_door", () -> new BlockItem(Registry.PALM_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_LEAVES_ITEM = ItemRegistry.ITEMS.register("baobab_leaves", () -> new BlockItem(Registry.BAOBAB_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_LEAVES_ITEM = ItemRegistry.ITEMS.register("palm_leaves", () -> new BlockItem(Registry.PALM_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_LOG_ITEM = ItemRegistry.ITEMS.register("baobab_log", () -> new BlockItem(Registry.PALM_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_LOG_ITEM = ItemRegistry.ITEMS.register("palm_log", () -> new BlockItem(Registry.PALM_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_PLANKS_ITEM = ItemRegistry.ITEMS.register("baobab_planks", () -> new BlockItem(Registry.BAOBAB_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_PLANKS_ITEM = ItemRegistry.ITEMS.register("palm_planks", () -> new BlockItem(Registry.PALM_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_SAPLING_ITEM = ItemRegistry.ITEMS.register("baobab_sapling", () -> new BlockItem(Registry.BAOBAB_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> PALM_SAPLING_ITEM = ItemRegistry.ITEMS.register("palm_sapling", () -> new BlockItem(Registry.PALM_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> BAOBAB_SING_ITEM = ItemRegistry.ITEMS.register("baobab_sing", () -> new BlockItem(Registry.BAOBAB_SING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> PALM_SING_ITEM = ItemRegistry.ITEMS.register("palm_sing", () -> new BlockItem(Registry.PALM_SING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> BAOBAB_TRAPDOOR_ITEM = ItemRegistry.ITEMS.register("baobab_trapdoor", () -> new BlockItem(Registry.BAOBAB_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_TRAPDOOR_ITEM = ItemRegistry.ITEMS.register("palm_trapdoor", () -> new BlockItem(Registry.PALM_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_WOOD = ItemRegistry.ITEMS.register("baobab_wood", () -> new BlockItem(Registry.BAOBAB_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_WOOD = ItemRegistry.ITEMS.register("palm_wood", () -> new BlockItem(Registry.PALM_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_SLAB = ItemRegistry.ITEMS.register("baobab_slab", () -> new BlockItem(Registry.BAOBAB_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_SLAB = ItemRegistry.ITEMS.register("palm_slab", () -> new BlockItem(Registry.PALM_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_STAIRS = ItemRegistry.ITEMS.register("baobab_stairs", () -> new BlockItem(Registry.BAOBAB_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_STAIRS = ItemRegistry.ITEMS.register("palm_stairs", () -> new BlockItem(Registry.PALM_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

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
    public static final RegistryObject<ForgeSpawnEggItem> VULTURE_SPAWN_EGG = ItemRegistry.ITEMS.register("vulture_spawn_egg", () -> new ForgeSpawnEggItem(Registry.VULTURE, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> FROG_SPAWN_EGG = ItemRegistry.ITEMS.register("frog_spawn_egg", () -> new ForgeSpawnEggItem(Registry.FROG, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TADPOLE_SPAWN_EGG = ItemRegistry.ITEMS.register("tadpole_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TADPOLE, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
