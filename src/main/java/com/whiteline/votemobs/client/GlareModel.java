package com.whiteline.votemobs.client;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.whiteline.votemobs.world.entity.Glare;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GlareModel<T extends Glare> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
    private final ModelPart head;
    private final ModelPart tail1;
    private final ModelPart tail2;

    public GlareModel(ModelPart root) {
        this.head = root.getChild("head");
        this.tail1 = root.getChild("tail1");
        this.tail2 = root.getChild("tail2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 30).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(5, 48).addBox(-5.0F, -12.0F, -1.0F, 10.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -14.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(56, 0).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition tail2 = partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(104, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entity.isAngry()) {
            this.tail1.yRot = -Mth.cos(ageInTicks * 45.836624F * ((float) Math.PI / 180F)) * (float) Math.PI * 0.05F;
            this.tail2.yRot = Mth.cos(ageInTicks * 45.836624F * ((float) Math.PI / 180F)) * (float) Math.PI * 0.05F;
        }else {
            this.tail1.yRot = -Mth.cos(ageInTicks * 15.836624F * ((float) Math.PI / 180F)) * (float) Math.PI * 0.05F;
            this.tail2.yRot = Mth.cos(ageInTicks * 15.836624F * ((float) Math.PI / 180F)) * (float) Math.PI * 0.05F;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, buffer, packedLight, packedOverlay);
        tail1.render(poseStack, buffer, packedLight, packedOverlay);
        tail2.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
