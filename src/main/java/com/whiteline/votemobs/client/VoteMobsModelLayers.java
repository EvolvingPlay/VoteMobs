package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoteMobsModelLayers {
    public static ModelLayerLocation GLARE = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"glare"), "glare");
    public static ModelLayerLocation ALLAY = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"allay"), "allay");
    public static ModelLayerLocation COPPER_GOLEM = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"copper_golem"), "copper_golem");

    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(VoteMobsModelLayers.GLARE, GlareModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.ALLAY, AllayModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.COPPER_GOLEM, CopperGolemModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Registry.GLARE.get(), GlareRenderer::new);
        event.registerEntityRenderer(Registry.ALLAY.get(), AllayRenderer::new);
        event.registerEntityRenderer(Registry.COPPER_GOLEM.get(), CopperGolemRenderer::new);

    }
}
