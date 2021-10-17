package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Glare;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlareRenderer extends MobRenderer<Glare, GlareModel<Glare>> {
    public GlareRenderer(EntityRendererProvider.Context context){
        super (context, new GlareModel<>(context.bakeLayer(VoteMobsModelLayers.GLARE)), 0.4F);
    }

    public ResourceLocation getTextureLocation(Glare glare){
        return glare.isAngry() ? new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/glare/glare_2.png") : new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/glare/glare.png");
    }
}
