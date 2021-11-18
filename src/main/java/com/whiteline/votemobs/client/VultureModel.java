package com.whiteline.votemobs.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class VultureModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "vulture"), "main");
    private final ModelPart spin;

    public VultureModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 20).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.25F))
                .texOffs(26, 47).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 11.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(12, 36).addBox(-1.5F, -3.0F, -8.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(21, 38).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(8, 56).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(13, 53).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition wing_R_1 = body.addOrReplaceChild("wing_R_1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -1.0F, 5.0F));

        PartDefinition wing_R_2 = wing_R_1.addOrReplaceChild("wing_R_2", CubeListBuilder.create().texOffs(1, 11).addBox(-6.0F, 0.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

        PartDefinition wing_L_1 = body.addOrReplaceChild("wing_L_1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -4.0F, 12.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -1.0F, 5.0F, 0.0F, 0.0F, 0.0F));

        PartDefinition wing_L_2 = wing_L_1.addOrReplaceChild("wing_L_2", CubeListBuilder.create().texOffs(1, 11).mirror().addBox(0.0F, 0.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, 0.0F, 0.0F));

        PartDefinition leg_R = body.addOrReplaceChild("leg_R", CubeListBuilder.create().texOffs(0, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).addBox(-1.5F, 2.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 3.0F, 6.0F));

        PartDefinition leg_L = body.addOrReplaceChild("leg_L", CubeListBuilder.create().texOffs(0, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).addBox(-1.5F, 2.0F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 3.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        spin.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
