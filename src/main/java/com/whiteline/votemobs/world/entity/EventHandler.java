package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.init.ItemRegistry;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void notifyAllay(NoteBlockEvent.Play e){
        List<Allay> list = e.getWorld().getEntitiesOfClass(Allay.class, new AABB(e.getPos()).inflate(12.0D, 12.0D, 12.0D));
        for (Allay allay: list){
            allay.setHomePoint(e.getPos());
            allay.setDanceTime();
            LOGGER.info(e.getPos());
        }
    }

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent e){
        if(e.getName()==null){
            return;
        }
        Biome biome = ForgeRegistries.BIOMES.getValue(e.getName());
        if(biome == null){
            return;
        }
        ResourceKey<Biome> resourceKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, e.getName());
        Set<BiomeDictionary.Type> biomes = BiomeDictionary.getTypes(resourceKey);
        if(resourceKey == Biomes.SOUL_SAND_VALLEY){
            e.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(Registry.ALLAY.get(), 80, 1, 1));
        }
        e.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(Registry.GLARE.get(), 40, 1, 1));
    }

    @SubscribeEvent
    public static void spawnGolem(BlockEvent.EntityPlaceEvent e){
        LOGGER.info("spawn");
        Level level = e.getEntity().level;
        if(e.getPlacedBlock().getBlock() == Blocks.CARVED_PUMPKIN){
            LOGGER.info("pumpkin");
            if(level.getBlockState(e.getPos().below()).getBlock() == Blocks.COPPER_BLOCK){
                LOGGER.info("copper");
                level.removeBlock(e.getPos(), false);
                level.removeBlock(e.getPos().below(), false);
                CopperGolem golem =  new CopperGolem(Registry.COPPER_GOLEM.get(), level);
                golem.setPos(Vec3.atBottomCenterOf(e.getPos()));
                level.addFreshEntity(golem);
            }
        }
    }

    @SubscribeEvent
    public static void registerSpawns(RegistryEvent.Register<EntityType<?>> event){
        LOGGER.info("spawns");
        SpawnPlacements.register(Registry.ALLAY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Allay::checkAllaySpawnRules);
    }

    @SubscribeEvent
    public static void registerEggs(RegistryEvent.Register<Item> event){
        LOGGER.info("Eggs");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(modEventBus);
    }
}
