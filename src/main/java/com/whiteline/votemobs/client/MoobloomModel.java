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

public class MoobloomModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;

    public MoobloomModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.leg1 = root.getChild("leg1");
        this.leg2 = root.getChild("leg2");
        this.leg3 = root.getChild("leg3");
        this.leg4 = root.getChild("leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 2.0F));

        PartDefinition rotation = body.addOrReplaceChild("rotation", CubeListBuilder.create().texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(28, -7).addBox(4.0F, -9.0F, 3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(45, 7).addBox(2.0F, -7.0F, 3.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(45, 7).addBox(-5.0F, 2.0F, 3.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(28, -7).addBox(-3.0F, 0.0F, 3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(45, 7).addBox(1.0F, 5.0F, 3.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(28, -7).addBox(3.0F, 3.0F, 3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(45, 7).addBox(-4.0F, -5.0F, 3.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(28, -7).addBox(-2.0F, -7.0F, 3.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(52, 3).addBox(-2.0F, -11.0F, -6.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 7).addBox(-4.0F, -11.0F, -4.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -8.0F));

        PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).addBox(-10.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 7.0F));

        PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).addBox(6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, 7.0F));

        PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).addBox(-10.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, -6.0F));

        PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).addBox(6.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, -6.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        head.render(poseStack, buffer, packedLight, packedOverlay);
        leg1.render(poseStack, buffer, packedLight, packedOverlay);
        leg2.render(poseStack, buffer, packedLight, packedOverlay);
        leg3.render(poseStack, buffer, packedLight, packedOverlay);
        leg4.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
