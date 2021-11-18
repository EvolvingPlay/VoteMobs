package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.EternalHunger;
import com.whiteline.votemobs.world.entity.Firefly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EternalHungerRenderer extends MobRenderer<EternalHunger, EternalHungerModel<EternalHunger>> {
    public ResourceLocation getTextureLocation(EternalHunger eternalhunger) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/eternal_hunger/eternal_hunger.png");
    }

    public EternalHungerRenderer(EntityRendererProvider.Context context) {
        super(context, new EternalHungerModel<>(context.bakeLayer(VoteMobsModelLayers.ETERNALHUNGER)), 0.4F);
    }
}
