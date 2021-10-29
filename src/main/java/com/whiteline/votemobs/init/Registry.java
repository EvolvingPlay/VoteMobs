package com.whiteline.votemobs.init;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Allay;
import com.whiteline.votemobs.world.entity.CopperGolem;
import com.whiteline.votemobs.world.entity.Glare;
import com.whiteline.votemobs.world.level.block.CopperButton;
import com.whiteline.votemobs.world.level.block.WaxedButton;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
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

    public static final RegistryObject<Block> COPPER_BUTTON = Registry.BLOCKS.register("copper_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final RegistryObject<Block> EXPOSED_BUTTON = Registry.BLOCKS.register("exposed_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.EXPOSED));
    public static final RegistryObject<Block> OXIDIZED_BUTTON = Registry.BLOCKS.register("oxidized_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.OXIDIZED));
    public static final RegistryObject<Block> WEATHERED_BUTTON = Registry.BLOCKS.register("weathered_button", () -> new CopperButton(true, BlockBehaviour.Properties.of(Material.DECORATION).noCollission().sound(SoundType.COPPER), WeatheringCopper.WeatherState.WEATHERED));

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
