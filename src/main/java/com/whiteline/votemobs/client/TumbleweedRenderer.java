package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Moobloom;
import com.whiteline.votemobs.world.entity.Tumbleweed;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TumbleweedRenderer extends MobRenderer<Tumbleweed, TumbleweedModel<Tumbleweed>> {
    public ResourceLocation getTextureLocation(Tumbleweed tumbleweed) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/tumbleweed/tumbleweed.png");
    }

    public TumbleweedRenderer(EntityRendererProvider.Context context) {
        super(context, new TumbleweedModel<>(context.bakeLayer(VoteMobsModelLayers.TUMBLEWEED)), 0.4F);
    }
}
