package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Moobloom;
import com.whiteline.votemobs.world.entity.Vulture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VultureRenderer extends MobRenderer<Vulture, VultureModel<Vulture>> {
    public ResourceLocation getTextureLocation(Vulture vulture) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/vulture/vulture.png");
    }

    public VultureRenderer(EntityRendererProvider.Context context) {
        super(context, new VultureModel<>(context.bakeLayer(VoteMobsModelLayers.VULTURE)), 0.4F);
    }
}
