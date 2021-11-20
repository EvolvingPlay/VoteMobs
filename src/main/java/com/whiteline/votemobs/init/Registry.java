package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.*;
import com.whiteline.votemobs.world.level.block.CopperButton;
import com.whiteline.votemobs.world.level.block.WaxedButton;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.DarkOakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = VoteMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Registry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, VoteMobs.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoteMobs.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, VoteMobs.MOD_ID);

    public static final RegistryObject<EntityType<Glare>> GLARE = Registry.ENTITIES.register("glare", () -> EntityType.Builder.of(Glare::new, MobCategory.CREATURE).sized(0.9f, 0.9f).build(VoteMobs.MOD_ID+"glare"));
    public static final RegistryObject<EntityType<Allay>> ALLAY = Registry.ENTITIES.register("allay", () -> EntityType.Builder.of(Allay::new, MobCategory.CREATURE).sized(0.5f, 0.6f).build(VoteMobs.MOD_ID+"allay"));
    public static final RegistryObject<EntityType<CopperGolem>> COPPER_GOLEM = Registry.ENTITIES.register("copper_golem", () -> EntityType.Builder.of(CopperGolem::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"copper_golem"));
    public static final RegistryObject<EntityType<Moobloom>> MOOBLOOM = Registry.ENTITIES.register("moobloom", () -> EntityType.Builder.of(Moobloom::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"moobloom"));
    public static final RegistryObject<EntityType<Vulture>> VULTURE = Registry.ENTITIES.register("vulture", () -> EntityType.Builder.of(Vulture::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"vulture"));
    public static final RegistryObject<EntityType<Tumbleweed>> TUMBLEWEED = Registry.ENTITIES.register("tumbleweed", () -> EntityType.Builder.of(Tumbleweed::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"tumbleweed"));
    public static final RegistryObject<EntityType<Termite>> TERMITE = Registry.ENTITIES.register("termite", () -> EntityType.Builder.of(Termite::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"termite"));
    public static final RegistryObject<EntityType<Ostrich>> OSTRICH = Registry.ENTITIES.register("ostrich", () -> EntityType.Builder.of(Ostrich::new, MobCategory.CREATURE).sized(1, 2).build(VoteMobs.MOD_ID+"ostrich"));
    public static final RegistryObject<EntityType<Meerkat>> MEERKAT = Registry.ENTITIES.register("meerkat", () -> EntityType.Builder.of(Meerkat::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"meerkat"));
    public static final RegistryObject<EntityType<Inferno>> INFERNO = Registry.ENTITIES.register("inferno", () -> EntityType.Builder.of(Inferno::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"inferno"));
    public static final RegistryObject<EntityType<Firefly>> FIREFLY = Registry.ENTITIES.register("firefly", () -> EntityType.Builder.of(Firefly::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"firefly"));
    public static final RegistryObject<EntityType<EternalHunger>> ETERNALHUNGER = Registry.ENTITIES.register("eternal_hunger", () -> EntityType.Builder.of(EternalHunger::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"eternal_hunger"));
    public static final RegistryObject<EntityType<DeepSeaMonster>> DEEPSEAMONSTER = Registry.ENTITIES.register("deep_sea_monster", () -> EntityType.Builder.of(DeepSeaMonster::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"deep_sea_monster"));
    public static final RegistryObject<EntityType<Frog>> FROG = Registry.ENTITIES.register("frog", () -> EntityType.Builder.of(Frog::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"frog"));
    public static final RegistryObject<EntityType<Tadpole>> TADPOLE = Registry.ENTITIES.register("tadpole", () -> EntityType.Builder.of(Tadpole::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"tadpole"));

    public static final RegistryObject<Block> COPPER_BUTTON = Registry.BLOCKS.register("copper_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> EXPOSED_BUTTON = Registry.BLOCKS.register("exposed_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> OXIDIZED_BUTTON = Registry.BLOCKS.register("oxidized_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<Block> WEATHERED_BUTTON = Registry.BLOCKS.register("weathered_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.WEATHERED));
    public static final RegistryObject<Block> BAOBAB_BUTTON = Registry.BLOCKS.register("baobab_button", () -> new ButtonBlock(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD)) {
        @Override
        protected SoundEvent getSound(boolean p_51102_) {
            return null;
        }
    });
    public static final RegistryObject<Block> PALM_BUTTON = Registry.BLOCKS.register("palm_button", () -> new ButtonBlock(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD)) {
        @Override
        protected SoundEvent getSound(boolean p_51102_) {
            return null;
        }
    });

    public static final RegistryObject<Block> WAXED_COPPER_BUTTON = Registry.BLOCKS.register("waxed_copper_button", () -> new WaxedButton(true, BlockBehaviour.Properties.copy(COPPER_BUTTON.get())));
    public static final RegistryObject<Block> WAXED_EXPOSED_BUTTON = Registry.BLOCKS.register("waxed_exposed_button", () -> new WaxedButton(true, BlockBehaviour.Properties.copy(COPPER_BUTTON.get())));
    public static final RegistryObject<Block> WAXED_OXIDIZED_BUTTON = Registry.BLOCKS.register("waxed_oxidized_button", () -> new WaxedButton(true, BlockBehaviour.Properties.copy(COPPER_BUTTON.get())));
    public static final RegistryObject<Block> WAXED_WEATHERED_BUTTON = Registry.BLOCKS.register("waxed_weathered_button", () -> new WaxedButton(true, BlockBehaviour.Properties.copy(COPPER_BUTTON.get())));

    public static final RegistryObject<SoundEvent> GLARE_AMBIENT = Registry.SOUNDS.register("entity.glare.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.glare.ambient")));
    public static final RegistryObject<SoundEvent> GLARE_HURT = Registry.SOUNDS.register("entity.glare.hurt", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.glare.hurt")));
    public static final RegistryObject<SoundEvent> ALLAY_AMBIENT = Registry.SOUNDS.register("entity.allay.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.allay.ambient")));
    public static final RegistryObject<SoundEvent> ALLAY_DANCE = Registry.SOUNDS.register("entity.allay.dance", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.allay.dance")));
    public static final RegistryObject<SoundEvent> COPPER_GOLEM_AMBIENT = Registry.SOUNDS.register("entity.copper_golem.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.copper_golem.ambient")));
    public static final RegistryObject<SoundEvent> COPPER_GOLEM_HURT = Registry.SOUNDS.register("entity.copper_golem.hurt", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.copper_golem.hurt")));

    public static final RegistryObject<Block> BAOBAB_DOOR = Registry.BLOCKS.register("baobab_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_DOOR = Registry.BLOCKS.register("palm_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_LEAVES = Registry.BLOCKS.register("baobab_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PALM_LEAVES = Registry.BLOCKS.register("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BAOBAB_LOG = Registry.BLOCKS.register("baobab_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_LOG = Registry.BLOCKS.register("palm_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_PLANKS = Registry.BLOCKS.register("baobab_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_PLANKS = Registry.BLOCKS.register("palm_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_SAPLING = Registry.BLOCKS.register("baobab_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PALM_SAPLING = Registry.BLOCKS.register("palm_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BAOBAB_SING = Registry.BLOCKS.register("baobab_sing", () -> new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodType.BAOBAB));
    public static final RegistryObject<Block> PALM_SING = Registry.BLOCKS.register("palm_sing", () -> new StandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodType.PALM));
    public static final RegistryObject<Block> BAOBAB_TRAPDOOR = Registry.BLOCKS.register("baobab_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> PALM_TRAPDOOR = Registry.BLOCKS.register("palm_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> BAOBAB_WOOD = Registry.BLOCKS.register("baobab_wood", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_WOOD = Registry.BLOCKS.register("palm_wood", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_WALL_SING = Registry.BLOCKS.register("baobab_wall_sing", () -> new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodType.BAOBAB));
    public static final RegistryObject<Block> PALM_WALL_SING = Registry.BLOCKS.register("palm_wall_sing", () -> new WallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), WoodType.PALM));
    public static final RegistryObject<Block> BAOBAB_SLAB = Registry.BLOCKS.register("baobab_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_SLAB = Registry.BLOCKS.register("palm_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_STAIRS = Registry.BLOCKS.register("baobab_stairs", () -> new StairBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_STAIRS = Registry.BLOCKS.register("palm_stairs", () -> new StairBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static void register(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SOUNDS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ENTITIES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
    }

    private static Item spawnEgg(EntityType<? extends Mob> type, int color, int color2){
        ResourceLocation eggID = new ResourceLocation(type.getRegistryName().getNamespace(), type.getRegistryName().getPath() + "_spawn_egg");
        return new SpawnEggItem(type, color, color2, new Item.Properties().tab(CreativeModeTab.TAB_MISC)).setRegistryName(eggID);
    }

}
