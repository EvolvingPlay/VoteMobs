package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Termite;
import com.whiteline.votemobs.world.entity.Tumbleweed;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TermiteRenderer extends MobRenderer<Termite, TermiteModel<Termite>> {
    public ResourceLocation getTextureLocation(Termite termite) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/termite/termite.png");
    }

    public TermiteRenderer(EntityRendererProvider.Context context) {
        super(context, new TermiteModel<>(context.bakeLayer(VoteMobsModelLayers.TERMITE)), 0.4F);
    }
}
