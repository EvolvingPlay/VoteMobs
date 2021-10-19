package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.init.ItemRegistry;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;

@Mod.EventBusSubscriber(modid = VoteMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerSpawns(final RegistryEvent.Register<EntityType<?>> event){
        LOGGER.info("SPAWN");
        SpawnPlacements.register(Registry.ALLAY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Allay::checkAllaySpawnRules);
        SpawnPlacements.register(Registry.GLARE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Glare::checkGlareSpawnRules);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerEggs(final RegistryEvent.Register<Item> event){
        LOGGER.info("EGGS");
        ItemRegistry.register();
    }
}
