package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Allay;
import com.whiteline.votemobs.world.entity.CopperGolem;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CopperGolemRenderer extends MobRenderer<CopperGolem, CopperGolemModel<CopperGolem>> {
    public CopperGolemRenderer(EntityRendererProvider.Context context){
        super (context, new CopperGolemModel<>(context.bakeLayer(VoteMobsModelLayers.COPPER_GOLEM)), 0.4F);
    }

    public ResourceLocation getTextureLocation(CopperGolem golem){
        return golem.getOxidizeTexture();
    }
}
