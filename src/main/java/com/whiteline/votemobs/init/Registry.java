package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.*;
import com.whiteline.votemobs.world.level.block.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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

    //entity
    public static final RegistryObject<EntityType<Glare>> GLARE = Registry.ENTITIES.register("glare", () -> EntityType.Builder.of(Glare::new, MobCategory.CREATURE).sized(0.9f, 0.9f).build(VoteMobs.MOD_ID+"glare"));
    public static final RegistryObject<EntityType<Allay>> ALLAY = Registry.ENTITIES.register("allay", () -> EntityType.Builder.of(Allay::new, MobCategory.CREATURE).sized(0.5f, 0.6f).build(VoteMobs.MOD_ID+"allay"));
    public static final RegistryObject<EntityType<CopperGolem>> COPPER_GOLEM = Registry.ENTITIES.register("copper_golem", () -> EntityType.Builder.of(CopperGolem::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"copper_golem"));
    public static final RegistryObject<EntityType<Moobloom>> MOOBLOOM = Registry.ENTITIES.register("moobloom", () -> EntityType.Builder.of(Moobloom::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"moobloom"));
    public static final RegistryObject<EntityType<Vulture>> VULTURE = Registry.ENTITIES.register("vulture", () -> EntityType.Builder.of(Vulture::new, MobCategory.CREATURE).sized(1, 1).immuneTo(Blocks.CACTUS).build(VoteMobs.MOD_ID+"vulture"));
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
    public static final RegistryObject<EntityType<Iceloger>> ICELOGER = Registry.ENTITIES.register("iceloger", () -> EntityType.Builder.of(Iceloger::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"iceloger"));
    public static final RegistryObject<EntityType<IcelogerBlocks>> ICELOGERBLOCKS = Registry.ENTITIES.register("icelogerblocks", () -> EntityType.Builder.of(IcelogerBlocks::new, MobCategory.CREATURE).sized(1, 1).build(VoteMobs.MOD_ID+"iceloger"));

    //copper buttons
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

    //SE
    public static final RegistryObject<SoundEvent> GLARE_AMBIENT = Registry.SOUNDS.register("entity.glare.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.glare.ambient")));
    public static final RegistryObject<SoundEvent> GLARE_HURT = Registry.SOUNDS.register("entity.glare.hurt", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.glare.hurt")));
    public static final RegistryObject<SoundEvent> ALLAY_AMBIENT = Registry.SOUNDS.register("entity.allay.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.allay.ambient")));
    public static final RegistryObject<SoundEvent> ALLAY_DANCE = Registry.SOUNDS.register("entity.allay.dance", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.allay.dance")));
    public static final RegistryObject<SoundEvent> COPPER_GOLEM_AMBIENT = Registry.SOUNDS.register("entity.copper_golem.ambient", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.copper_golem.ambient")));
    public static final RegistryObject<SoundEvent> COPPER_GOLEM_HURT = Registry.SOUNDS.register("entity.copper_golem.hurt", () -> new SoundEvent(new ResourceLocation(VoteMobs.MOD_ID, "entity.copper_golem.hurt")));

    //mangove
    public static final RegistryObject<Block> MANGROVE_DOOR = Registry.BLOCKS.register("mangrove_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_SAPLING = Registry.BLOCKS.register("mangrove_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MANGROVE_TRAPDOOR = Registry.BLOCKS.register("mangrove_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_WOOD = Registry.BLOCKS.register("mangrove_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_SLAB = Registry.BLOCKS.register("mangrove_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_STAIRS = Registry.BLOCKS.register("mangrove_stairs", () -> new StairBlock(MANGROVE_WOOD.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_BUTTON = Registry.BLOCKS.register("mangrove_button", () -> new ButtonBlock(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.WOOD)) {
        @Override
        protected SoundEvent getSound(boolean p_51102_) {
            return null;
        }
    });
    public static final RegistryObject<Block> MANGROVE_LEAVES = Registry.BLOCKS.register("mangrove_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MANGROVE_LOG = Registry.BLOCKS.register("mangrove_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_PLANKS = Registry.BLOCKS.register("mangrove_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_ROOT = Registry.BLOCKS.register("mangrove_root", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_FENCE = Registry.BLOCKS.register("mangrove_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MANGROVE_FENCE_GATE = Registry.BLOCKS.register("mangrove_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> MANGROVE_PRESSURE_PLATE = Registry.BLOCKS.register("mangrove_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));

    //baobab
    public static final RegistryObject<Block> BAOBAB_FENCE = Registry.BLOCKS.register("baobab_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> BAOBAB_PLANKS = Registry.BLOCKS.register("baobab_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_FENCE_GATE = Registry.BLOCKS.register("baobab_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> BAOBAB_PRESSURE_PLATE = Registry.BLOCKS.register("baobab_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> BAOBAB_STAIRS = Registry.BLOCKS.register("baobab_stairs", () -> new StairBlock(BAOBAB_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_SLAB = Registry.BLOCKS.register("baobab_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_WOOD = Registry.BLOCKS.register("baobab_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_TRAPDOOR = Registry.BLOCKS.register("baobab_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> BAOBAB_LOG = Registry.BLOCKS.register("baobab_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_LEAVES = Registry.BLOCKS.register("baobab_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BAOBAB_DOOR = Registry.BLOCKS.register("baobab_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_SAPLING = Registry.BLOCKS.register("baobab_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    //palm
    public static final RegistryObject<Block> PALM_FENCE = Registry.BLOCKS.register("palm_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> PALM_PLANKS = Registry.BLOCKS.register("palm_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_FENCE_GATE = Registry.BLOCKS.register("palm_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = Registry.BLOCKS.register("palm_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> PALM_STAIRS = Registry.BLOCKS.register("palm_stairs", () -> new StairBlock(PALM_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_SLAB = Registry.BLOCKS.register("palm_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_WOOD = Registry.BLOCKS.register("palm_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_TRAPDOOR = Registry.BLOCKS.register("palm_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> PALM_SAPLING = Registry.BLOCKS.register("palm_sapling", () -> new SaplingBlock(new DarkOakTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PALM_LOG = Registry.BLOCKS.register("palm_log", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_LEAVES = Registry.BLOCKS.register("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PALM_DOOR = Registry.BLOCKS.register("palm_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_CROWN_BLOCK = Registry.BLOCKS.register("palm_crown_block", () ->  new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
        return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL:MaterialColor.PODZOL;
    }).strength(2.0F).sound(SoundType.WOOD)));

    //termite
    public static final RegistryObject<Block> TERMITE_BLOCK_1 = Registry.BLOCKS.register("termite_block_1", () -> new TermiteBlock1(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TERMITE_BLOCK_2 = Registry.BLOCKS.register("termite_block_2", () -> new TermiteBlock2(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TERMITE_BLOCK_3 = Registry.BLOCKS.register("termite_block_3", () -> new TermiteBlock3(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TERMITE_BLOCK_1_POPULATED = Registry.BLOCKS.register("termite_block_1_populated", () -> new TermiteBlock1Populated(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TERMITE_BLOCK_2_POPULATED = Registry.BLOCKS.register("termite_block_2_populated", () -> new TermiteBlock2Populated(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TERMITE_BLOCK_3_POPULATED = Registry.BLOCKS.register("termite_block_3_populated", () -> new TermiteBlock3Populated(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_LOG_INFESTED = Registry.BLOCKS.register("acacia_log_infested", () -> new AcaciaLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAOBAB_LOG_INFESTED = Registry.BLOCKS.register("baobab_log_infested", () -> new BaobabLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_LOG_INFESTED = Registry.BLOCKS.register("birch_log_infested", () -> new BirchLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_LOG_INFESTED = Registry.BLOCKS.register("dark_oak_log_infested", () -> new DarkOakLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_LOG_INFESTED = Registry.BLOCKS.register("jungle_log_infested", () -> new JungleLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_LOG_INFESTED = Registry.BLOCKS.register("mangrove_log_infested", () -> new MangroveLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_LOG_INFESTED = Registry.BLOCKS.register("oak_log_infested", () -> new OakLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PALM_LOG_INFESTED = Registry.BLOCKS.register("palm_log_infested", () -> new PalmLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_LOG_INFESTED = Registry.BLOCKS.register("spruce_log_infested", () -> new SpruceLogInfested(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    //Cactus
    public static final RegistryObject<Block> PRICKLY_PEAR_BIG_PAD = Registry.BLOCKS.register("prickly_pear_big_pad", () -> new PricklyPearBigPad(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PRICKLY_PEAR_SMALL_PAD_FETUS_STAGE_1 = Registry.BLOCKS.register("prickly_pear_small_pad_fetus_stage1", () -> new PricklyPearSmallPadFetusStage1(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PRICKLY_PEAR_SMALL_PAD_FETUS_STAGE_2 = Registry.BLOCKS.register("prickly_pear_small_pad_fetus_stage2", () -> new PricklyPearSmallPadFetusStage2(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PRICKLY_PEAR_SMALL_PAD_STAGE_1 = Registry.BLOCKS.register("prickly_pear_small_pad_stage1", () -> new PricklyPearSmallPadStage1(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PRICKLY_PEAR_SMALL_PAD_STAGE_2 = Registry.BLOCKS.register("prickly_pear_small_pad_stage2", () -> new PricklyPearSmallPadStage2(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_PRICKLY_PEAR_BIG_PAD = Registry.BLOCKS.register("stripped_prickly_pear_big_pad", () -> new StrippedPricklyPearBigPad(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_PRICKLY_PEAR_SMALL_PAD_STAGE_1 = Registry.BLOCKS.register("stripped_prickly_pear_small_pad_stage1", () -> new StrippedPricklyPearSmallPadStage1(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_PRICKLY_PEAR_SMALL_PAD_STAGE_2 = Registry.BLOCKS.register("stripped_prickly_pear_small_pad_stage2", () -> new StrippedPricklyPearSmallPadStage2(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_ORANGE).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    //other
    public static final RegistryObject<Block> BUTTERCUP = Registry.BLOCKS.register("buttercup", () -> new FlowerBlock(MobEffects.INVISIBILITY, 8, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<EntityType<ThrowableItemProjectile>> THROWN_OSTRICH_EGG = Registry.ENTITIES.register("thrown_ostrich_egg", () -> EntityType.Builder.<ThrowableItemProjectile>of(ThrownOstrichEgg::new, MobCategory.MISC).sized(1, 1).build(VoteMobs.MOD_ID+"thrown_ostrich_egg"));

    //food
    public static final FoodProperties PRICKLY_PEAR_FRUIT = (new FoodProperties.Builder()).nutrition(2).saturationMod(8F).build();
    public static final FoodProperties FRIED_EGG = (new FoodProperties.Builder()).nutrition(5).saturationMod(16F).build();
    public static final FoodProperties COCONUT_DRINK = (new FoodProperties.Builder()).nutrition(5).saturationMod(16F).build();
    public static final FoodProperties PRICKLY_PEAR_SALAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(16F).build();

    //under
            ;public static void register(){
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
