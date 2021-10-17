package com.whiteline.votemobs.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Allay;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Vex;

public class AllayRenderer extends HumanoidMobRenderer<Allay, AllayModel<Allay>> {
    public AllayRenderer(EntityRendererProvider.Context context) {
        super(context, new AllayModel<>(context.bakeLayer(VoteMobsModelLayers.ALLAY)), 0.3F);
    }

    public ResourceLocation getTextureLocation(Allay allay) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/allay/allay.png");
    }

    protected void scale(Allay p_116294_, PoseStack p_116295_, float p_116296_) {
        p_116295_.scale(0.4F, 0.4F, 0.4F);
    }

    protected void setupRotations(Allay p_115317_, PoseStack p_115318_, float p_115319_, float p_115320_, float p_115321_) {
        if(p_115317_.getDanceTime() > 0){
            p_115318_.mulPose(Vector3f.YP.rotationDegrees(p_115317_.getDanceTime()));
            p_115317_.decreaseDanceTime();
        }else super.setupRotations(p_115317_, p_115318_, p_115319_, p_115320_, p_115321_);
    }
}