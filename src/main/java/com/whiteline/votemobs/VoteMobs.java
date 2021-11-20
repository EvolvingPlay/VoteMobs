package com.whiteline.votemobs;

import com.whiteline.votemobs.init.Registry;
import com.whiteline.votemobs.world.entity.*;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("votemobs")
public class VoteMobs
{
    public static final String MOD_ID = "votemobs";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public VoteMobs() {
        Registry.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addAttributes);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }

    private void addAttributes(final EntityAttributeCreationEvent event){
        event.put(Registry.GLARE.get(), Glare.createAttributes().build());
        event.put(Registry.ALLAY.get(), Allay.createAttributes().build());
        event.put(Registry.COPPER_GOLEM.get(), CopperGolem.createAttributes().build());
        event.put(Registry.MOOBLOOM.get(), CopperGolem.createAttributes().build());
        event.put(Registry.VULTURE.get(), CopperGolem.createAttributes().build());
        event.put(Registry.TUMBLEWEED.get(), CopperGolem.createAttributes().build());
        event.put(Registry.TERMITE.get(), CopperGolem.createAttributes().build());
        event.put(Registry.OSTRICH.get(), Ostrich.createAttributes().build());
        event.put(Registry.MEERKAT.get(), Meerkat.createAttributes().build());
        event.put(Registry.INFERNO.get(), CopperGolem.createAttributes().build());
        event.put(Registry.FIREFLY.get(), Firefly.createAttributes().build());
        event.put(Registry.ETERNALHUNGER.get(), CopperGolem.createAttributes().build());
        event.put(Registry.DEEPSEAMONSTER.get(), CopperGolem.createAttributes().build());
        event.put(Registry.FROG.get(), CopperGolem.createAttributes().build());
        event.put(Registry.TADPOLE.get(), CopperGolem.createAttributes().build());

    }

    private void doClientStuff(final FMLClientSetupEvent event){

    }

    private void doBlockStuff(final NoteBlockEvent event){}
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}
