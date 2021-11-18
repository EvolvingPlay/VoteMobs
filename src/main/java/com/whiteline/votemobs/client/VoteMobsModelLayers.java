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
    public static ModelLayerLocation MOOBLOOM = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"moobloom"), "moobloom");
    public static ModelLayerLocation VULTURE = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"vulture"), "vulture");
    public static ModelLayerLocation TUMBLEWEED = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"tumbleweed"), "tumbleweed");
    public static ModelLayerLocation TERMITE = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"termite"), "termite");
    public static ModelLayerLocation OSTRICH = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"ostrich"), "ostrich");
    public static ModelLayerLocation MEERKAT = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"meerkat"), "meerkat");
    public static ModelLayerLocation INFERNO = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"inferno"), "inferno");
    public static ModelLayerLocation FIREFLY = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"firefly"), "firefly");
    public static ModelLayerLocation ETERNALHUNGER = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"eternal_hunger"), "eternal_hunger");
    public static ModelLayerLocation DEEPSEAMONSTER = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"deep_sea_monster"), "deep_sea_monster");
    public static ModelLayerLocation FROG = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"frog"), "frog");
    public static ModelLayerLocation TADPOLE = new ModelLayerLocation(new ResourceLocation(VoteMobs.MOD_ID+"tadpole"), "tadpole");


    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(VoteMobsModelLayers.GLARE, GlareModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.ALLAY, AllayModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.COPPER_GOLEM, CopperGolemModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.MOOBLOOM, MoobloomModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.VULTURE, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.TUMBLEWEED, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.TERMITE, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.OSTRICH, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.MEERKAT, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.INFERNO, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.FIREFLY, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.ETERNALHUNGER, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.DEEPSEAMONSTER, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.FROG, VultureModel::createBodyLayer);
        event.registerLayerDefinition(VoteMobsModelLayers.TADPOLE, VultureModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Registry.GLARE.get(), GlareRenderer::new);
        event.registerEntityRenderer(Registry.ALLAY.get(), AllayRenderer::new);
        event.registerEntityRenderer(Registry.COPPER_GOLEM.get(), CopperGolemRenderer::new);
        event.registerEntityRenderer(Registry.MOOBLOOM.get(), MoobloomRenderer::new);
        event.registerEntityRenderer(Registry.VULTURE.get(), VultureRenderer::new);
        event.registerEntityRenderer(Registry.TUMBLEWEED.get(), TumbleweedRenderer::new);
        event.registerEntityRenderer(Registry.TERMITE.get(), TermiteRenderer::new);
        event.registerEntityRenderer(Registry.OSTRICH.get(), OstrichRenderer::new);
        event.registerEntityRenderer(Registry.MEERKAT.get(), MeerkatRenderer::new);
        event.registerEntityRenderer(Registry.INFERNO.get(), InfernoRenderer::new);
        event.registerEntityRenderer(Registry.FIREFLY.get(), FireflyRenderer::new);
        event.registerEntityRenderer(Registry.ETERNALHUNGER.get(), EternalHungerRenderer::new);
        event.registerEntityRenderer(Registry.DEEPSEAMONSTER.get(), DeepSeaMonsterRenderer::new);
        event.registerEntityRenderer(Registry.FROG.get(), DeepSeaMonsterRenderer::new);
        event.registerEntityRenderer(Registry.TADPOLE.get(), DeepSeaMonsterRenderer::new);

    }
}
