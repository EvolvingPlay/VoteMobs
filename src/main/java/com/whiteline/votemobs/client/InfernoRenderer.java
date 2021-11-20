package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Inferno;
import com.whiteline.votemobs.world.entity.Moobloom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class InfernoRenderer extends MobRenderer<Inferno, InfernoModel<Inferno>> {
    public ResourceLocation getTextureLocation(Inferno inferno) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/inferno/inferno.png");
    }

    public InfernoRenderer(EntityRendererProvider.Context context) {
        super(context, new InfernoModel<>(context.bakeLayer(VoteMobsModelLayers.INFERNO)), 0.4F);
    }

}
