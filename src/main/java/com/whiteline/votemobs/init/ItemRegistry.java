package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.DarkOakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoteMobs.MOD_ID);

    //copper buttons
    public static final RegistryObject<BlockItem> COPPER_BUTTON_ITEM = ItemRegistry.ITEMS.register("copper_button", () -> new BlockItem(Registry.COPPER_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> EXPOSED_BUTTON_ITEM = ItemRegistry.ITEMS.register("exposed_button", () -> new BlockItem(Registry.EXPOSED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> OXIDISED_BUTTON_ITEM = ItemRegistry.ITEMS.register("oxidized_button", () -> new BlockItem(Registry.OXIDIZED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WEATHERED_BUTTON_ITEM = ItemRegistry.ITEMS.register("weathered_button", () -> new BlockItem(Registry.WEATHERED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_COPPER_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_copper_button", () -> new BlockItem(Registry.WAXED_COPPER_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_EXPOSED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_exposed_button", () -> new BlockItem(Registry.WAXED_EXPOSED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_OXIDISED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_oxidized_button", () -> new BlockItem(Registry.WAXED_OXIDIZED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> WAXED_WEATHERED_BUTTON_ITEM = ItemRegistry.ITEMS.register("waxed_weathered_button", () -> new BlockItem(Registry.WAXED_WEATHERED_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    //mangrove
    public static final RegistryObject<BlockItem> MANGROVE_DOOR_ITEM = ItemRegistry.ITEMS.register("mangrove_door", () -> new BlockItem(Registry.MANGROVE_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> MANGROVE_LEAVES_ITEM = ItemRegistry.ITEMS.register("mangrove_leaves", () -> new BlockItem(Registry.MANGROVE_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_LOG_ITEM = ItemRegistry.ITEMS.register("mangrove_log", () -> new BlockItem(Registry.MANGROVE_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_PLANKS_ITEM = ItemRegistry.ITEMS.register("mangrove_planks", () -> new BlockItem(Registry.MANGROVE_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_SAPLING_ITEM = ItemRegistry.ITEMS.register("mangrove_sapling", () -> new BlockItem(Registry.MANGROVE_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> MANGROVE_TRAPDOOR_ITEM = ItemRegistry.ITEMS.register("mangrove_trapdoor", () -> new BlockItem(Registry.MANGROVE_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> MANGROVE_WOOD_ITEM = ItemRegistry.ITEMS.register("mangrove_wood", () -> new BlockItem(Registry.MANGROVE_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_SLAB_ITEM = ItemRegistry.ITEMS.register("mangrove_slab", () -> new BlockItem(Registry.MANGROVE_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_STAIRS_ITEM = ItemRegistry.ITEMS.register("mangrove_stairs", () -> new BlockItem(Registry.MANGROVE_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_BUTTON_ITEM = ItemRegistry.ITEMS.register("mangrove_button", () -> new BlockItem(Registry.MANGROVE_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> MANGROVE_ROOT_ITEM = ItemRegistry.ITEMS.register("mangrove_root", () -> new BlockItem(Registry.MANGROVE_ROOT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> MANGROVE_FENCE_ITEM = ItemRegistry.ITEMS.register("mangrove_fence", () -> new BlockItem(Registry.MANGROVE_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> MANGROVE_FENCE_GATE_ITEM = ItemRegistry.ITEMS.register("mangrove_fence_gate", () -> new BlockItem(Registry.MANGROVE_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> MANGROVE_PRESSURE_PLATE_ITEM = ItemRegistry.ITEMS.register("mangrove_pressure_plate", () -> new BlockItem(Registry.MANGROVE_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    //baobab
    public static final RegistryObject<BlockItem> BAOBAB_FENCE_ITEM = ItemRegistry.ITEMS.register("baobab_fence", () -> new BlockItem(Registry.BAOBAB_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_FENCE_GATE_ITEM = ItemRegistry.ITEMS.register("baobab_fence_gate", () -> new BlockItem(Registry.BAOBAB_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_PRESSURE_PLATE_ITEM = ItemRegistry.ITEMS.register("baobab_pressure_plate", () -> new BlockItem(Registry.BAOBAB_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_STAIRS_ITEM = ItemRegistry.ITEMS.register("baobab_stairs", () -> new BlockItem(Registry.BAOBAB_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_SLAB_ITEM = ItemRegistry.ITEMS.register("baobab_slab", () -> new BlockItem(Registry.BAOBAB_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_WOOD_ITEM = ItemRegistry.ITEMS.register("baobab_wood", () -> new BlockItem(Registry.BAOBAB_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_TRAPDOOR_ITEM = ItemRegistry.ITEMS.register("baobab_trapdoor", () -> new BlockItem(Registry.BAOBAB_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_SAPLING_ITEM = ItemRegistry.ITEMS.register("baobab_sapling", () -> new BlockItem(Registry.BAOBAB_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> BAOBAB_PLANKS_ITEM = ItemRegistry.ITEMS.register("baobab_planks", () -> new BlockItem(Registry.BAOBAB_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_LOG_ITEM = ItemRegistry.ITEMS.register("baobab_log", () -> new BlockItem(Registry.BAOBAB_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_LEAVES_ITEM = ItemRegistry.ITEMS.register("baobab_leaves", () -> new BlockItem(Registry.BAOBAB_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> BAOBAB_DOOR_ITEM = ItemRegistry.ITEMS.register("baobab_door", () -> new BlockItem(Registry.BAOBAB_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> BAOBAB_BUTTON_ITEM = ItemRegistry.ITEMS.register("baobab_button", () -> new BlockItem(Registry.BAOBAB_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    //palm
    public static final RegistryObject<BlockItem> PALM_FENCE_ITEM = ItemRegistry.ITEMS.register("palm_fence", () -> new BlockItem(Registry.PALM_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_FENCE_GATE_ITEM = ItemRegistry.ITEMS.register("palm_fence_gate", () -> new BlockItem(Registry.PALM_FENCE_GATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_PRESSURE_PLATE_ITEM = ItemRegistry.ITEMS.register("palm_pressure_plate", () -> new BlockItem(Registry.PALM_PRESSURE_PLATE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_STAIRS_ITEM = ItemRegistry.ITEMS.register("palm_stairs", () -> new BlockItem(Registry.PALM_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_SLAB_ITEM = ItemRegistry.ITEMS.register("palm_slab", () -> new BlockItem(Registry.PALM_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_WOOD_ITEM = ItemRegistry.ITEMS.register("palm_wood", () -> new BlockItem(Registry.PALM_WOOD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_TRAPDOOR_ITEM = ItemRegistry.ITEMS.register("palm_trapdoor", () -> new BlockItem(Registry.PALM_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_SAPLING_ITEM = ItemRegistry.ITEMS.register("palm_sapling", () -> new BlockItem(Registry.PALM_SAPLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<BlockItem> PALM_PLANKS_ITEM = ItemRegistry.ITEMS.register("palm_planks", () -> new BlockItem(Registry.PALM_PLANKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_LOG_ITEM = ItemRegistry.ITEMS.register("palm_log", () -> new BlockItem(Registry.PALM_LOG.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_LEAVES_ITEM = ItemRegistry.ITEMS.register("palm_leaves", () -> new BlockItem(Registry.PALM_LEAVES.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> PALM_DOOR_ITEM = ItemRegistry.ITEMS.register("palm_door", () -> new BlockItem(Registry.PALM_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
    public static final RegistryObject<BlockItem> PALM_BUTTON_ITEM = ItemRegistry.ITEMS.register("palm_button", () -> new BlockItem(Registry.PALM_BUTTON.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    //spawn egg
    public static final RegistryObject<ForgeSpawnEggItem> ALLAY_SPAWN = ItemRegistry.ITEMS.register("allay_spawn_egg", () -> new ForgeSpawnEggItem(Registry.ALLAY, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> GLARE_SPAWN_EGG = ItemRegistry.ITEMS.register("glare_spawn_egg", () -> new ForgeSpawnEggItem(Registry.GLARE, 0x00b300, 0xffa500, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> DEEP_SEA_MONSTER_SPAWN_EGG = ItemRegistry.ITEMS.register("deep_sea_monster_spawn_egg", () -> new ForgeSpawnEggItem(Registry.DEEPSEAMONSTER, 0x2c2e3a, 0x8c1e1e, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> ETERNAL_HUNGER_SPAWN_EGG = ItemRegistry.ITEMS.register("eternal_hunger_spawn_egg", () -> new ForgeSpawnEggItem(Registry.ETERNALHUNGER, 0x747474, 0x758a37, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> FIREFLY_SPAWN_EGG = ItemRegistry.ITEMS.register("firefly_spawn_egg", () -> new ForgeSpawnEggItem(Registry.FIREFLY, 0x465441, 0x9ee060, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> INFERNO_SPAWN_EGG = ItemRegistry.ITEMS.register("inferno_spawn_egg", () -> new ForgeSpawnEggItem(Registry.INFERNO, 0xffff84, 0x512930, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> MEERKAT_SPAWN_EGG = ItemRegistry.ITEMS.register("meerkat_spawn_egg", () -> new ForgeSpawnEggItem(Registry.MEERKAT, 0xe0ae75, 0x6b5036, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> MOOBLOOM_SPAWN_EGG = ItemRegistry.ITEMS.register("moobloom_spawn_egg", () -> new ForgeSpawnEggItem(Registry.MOOBLOOM, 0xf1df3d, 0xf0ecc0, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> OSTRICH_SPAWN_EGG = ItemRegistry.ITEMS.register("ostrich_spawn_egg", () -> new ForgeSpawnEggItem(Registry.OSTRICH, 0x484041, 0x8c8372, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TRMITE_SPAWN_EGG = ItemRegistry.ITEMS.register("termite_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TERMITE, 0xbc6839, 0xcba161, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TUMBLEWEES_SPAWN_EGG = ItemRegistry.ITEMS.register("tumbleweed_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TUMBLEWEED, 0x2a52be, 0x42aaff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> VULTURE_SPAWN_EGG = ItemRegistry.ITEMS.register("vulture_spawn_egg", () -> new ForgeSpawnEggItem(Registry.VULTURE, 0xcba161, 0xd6ccab, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> FROG_SPAWN_EGG = ItemRegistry.ITEMS.register("frog_spawn_egg", () -> new ForgeSpawnEggItem(Registry.FROG, 0xbe7654, 0xb7976f, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<ForgeSpawnEggItem> TADPOLE_SPAWN_EGG = ItemRegistry.ITEMS.register("tadpole_spawn_egg", () -> new ForgeSpawnEggItem(Registry.TADPOLE, 0x69594a, 0x392815, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
