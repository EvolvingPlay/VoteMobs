package com.whiteline.votemobs.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.whiteline.votemobs.world.entity.CopperGolem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class CopperGolemModel<T extends CopperGolem> extends EntityModel<T> {
    protected static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private final ModelPart arm_R;
    private final ModelPart arm_L;
    private final ModelPart head;
    private final ModelPart leg_R;
    private final ModelPart leg_L;
    private final ModelPart body;

    public CopperGolemModel(ModelPart root) {
        this.arm_R = root.getChild("arm_R");
        this.arm_L = root.getChild("arm_L");
        this.head = root.getChild("head");
        this.leg_R = root.getChild("leg_R");
        this.leg_L = root.getChild("leg_L");
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition arm_R = partdefinition.addOrReplaceChild("arm_R", CubeListBuilder.create().texOffs(49, 14).addBox(-4.0F, -2.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, 0.0F));

        PartDefinition arm_L = partdefinition.addOrReplaceChild("arm_L", CubeListBuilder.create().texOffs(49, 14).mirror().addBox(0.0F, -2.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 15.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(45, 6).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(34, 3).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 1).addBox(-4.5F, -6.0F, -4.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(50, 29).addBox(-1.5F, -3.0F, -6.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 13.0F, -1.0F));

        PartDefinition leg_R = partdefinition.addOrReplaceChild("leg_R", CubeListBuilder.create().texOffs(26, 26).addBox(-4.0F, .0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition leg_L = partdefinition.addOrReplaceChild("leg_L", CubeListBuilder.create().texOffs(26, 26).addBox(0.0F, .0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -11.0F, -3.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T p_102962_, float p_102963_, float p_102964_, float p_102965_, float p_102966_, float p_102967_) {
            this.head.yRot = p_102966_ * ((float) Math.PI / 180F);
            this.head.xRot = p_102967_ * ((float) Math.PI / 180F);
            if(p_102962_.getOxidize() < 3) {
                this.head.yRot = p_102962_.getHeadRotate() * (float) Math.PI * 2;
            }
            this.leg_R.xRot = -1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
            this.leg_L.xRot = 1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
            this.leg_R.yRot = 0.0F;
            this.leg_L.yRot = 0.0F;
    }

    public void prepareMobModel(T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
        int i = p_102957_.getAttackAnimationTick();
        LOGGER.info(i);
        if(i > 0){
            this.arm_R.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - p_102960_, 10.0F);
            this.arm_L.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - p_102960_, 10.0F);
        }else {
            this.arm_R.xRot = (-0.2F + 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
            this.arm_L.xRot = (-0.2F - 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        arm_R.render(poseStack, buffer, packedLight, packedOverlay);
        arm_L.render(poseStack, buffer, packedLight, packedOverlay);
        leg_R.render(poseStack, buffer, packedLight, packedOverlay);
        leg_L.render(poseStack, buffer, packedLight, packedOverlay);
        head.render(poseStack, buffer, packedLight, packedOverlay);
        body.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
