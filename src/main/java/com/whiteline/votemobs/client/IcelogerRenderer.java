package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Iceloger;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.SpellcasterIllager;

public class IcelogerRenderer extends MobRenderer<Iceloger, IcelogerModel<Iceloger>> {
    public ResourceLocation getTextureLocation(Iceloger iceloger) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/iceloger/iceloger.png");
    }

    public IcelogerRenderer(EntityRendererProvider.Context context) {
        super(context, new IcelogerModel<>(context.bakeLayer(VoteMobsModelLayers.ICELOGER)), 0.4F);
    }
}