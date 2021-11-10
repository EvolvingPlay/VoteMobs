package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Meerkat;
import com.whiteline.votemobs.world.entity.Moobloom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MeerkatRenderer extends MobRenderer<Meerkat, MeerkatModel<Meerkat>> {
    public ResourceLocation getTextureLocation(Moobloom moobloom) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/meerkat/meerkat.png");
    }

    public MeerkatRenderer(EntityRendererProvider.Context context) {
        super(context, new MeerkatModel<>(context.bakeLayer(VoteMobsModelLayers.MEERKAT)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(Meerkat p_114482_) {
        return null;
    }

}
