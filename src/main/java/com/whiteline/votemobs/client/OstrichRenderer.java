package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Moobloom;
import com.whiteline.votemobs.world.entity.Ostrich;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OstrichRenderer extends MobRenderer<Ostrich, OstrichModel<Ostrich>> {
    public ResourceLocation getTextureLocation(Moobloom moobloom) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/ostrich/ostrich.png");
    }

    public OstrichRenderer(EntityRendererProvider.Context context) {
        super(context, new OstrichModel<>(context.bakeLayer(VoteMobsModelLayers.OSTRICH)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(Ostrich p_114482_) {
        return null;
    }
}
