package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Firefly;
import com.whiteline.votemobs.world.entity.Frog;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FrogRenderer extends MobRenderer<Frog, FrogModel<Frog>> {
    public ResourceLocation getTextureLocation(Frog frog) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/frog/frog.png");
    }

    public FrogRenderer(EntityRendererProvider.Context context) {
        super(context, new FrogModel<>(context.bakeLayer(VoteMobsModelLayers.FROG)), 0.4F);
    }
}
