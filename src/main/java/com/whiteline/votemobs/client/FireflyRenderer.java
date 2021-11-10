package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Firefly;
import com.whiteline.votemobs.world.entity.Moobloom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FireflyRenderer extends MobRenderer<Firefly, FireflyModel<Firefly>> {
    public ResourceLocation getTextureLocation(Firefly firefly) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/firefly/firefly.png");
    }

    public FireflyRenderer(EntityRendererProvider.Context context) {
        super(context, new FireflyModel<>(context.bakeLayer(VoteMobsModelLayers.FIREFLY)), 0.4F);
    }
}
