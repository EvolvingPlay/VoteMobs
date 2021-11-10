package com.whiteline.votemobs.client;

// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class InfernoModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "inferno"), "main");
    private final ModelPart spin;

    public InfernoModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition stick = body.addOrReplaceChild("stick", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -11.0F, -2.5F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition shild_1 = stick.addOrReplaceChild("shild_1", CubeListBuilder.create().texOffs(20, 21).addBox(-5.0F, -8.0F, -11.0F, 10.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition shild_2 = stick.addOrReplaceChild("shild_2", CubeListBuilder.create().texOffs(20, 21).addBox(-5.0F, -8.0F, -11.0F, 10.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition shild_3 = stick.addOrReplaceChild("shild_3", CubeListBuilder.create().texOffs(20, 21).addBox(-5.0F, -8.0F, -11.0F, 10.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition shild_4 = stick.addOrReplaceChild("shild_4", CubeListBuilder.create().texOffs(20, 21).addBox(-5.0F, -8.0F, -11.0F, 10.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.5F))
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

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
