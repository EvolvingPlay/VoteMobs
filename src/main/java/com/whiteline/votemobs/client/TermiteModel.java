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

public class TermiteModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "termite"), "main");
    private final ModelPart spin;

    public TermiteModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition ass = body.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

        PartDefinition leg_R1 = body.addOrReplaceChild("leg_R1", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, -1.5F));

        PartDefinition leg_R2 = body.addOrReplaceChild("leg_R2", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, 0.0F));

        PartDefinition leg_R3 = body.addOrReplaceChild("leg_R3", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 1.0F, 1.5F));

        PartDefinition leg_L1 = body.addOrReplaceChild("leg_L1", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, -1.5F));

        PartDefinition leg_L2 = body.addOrReplaceChild("leg_L2", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, 0.0F));

        PartDefinition leg_L3 = body.addOrReplaceChild("leg_L3", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, 0.0F, -0.5F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, 1.0F, 1.5F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(16, -1).addBox(2.0F, -1.0F, -7.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(16, -1).addBox(-2.0F, -1.0F, -7.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        spin.render(poseStack, buffer, packedLight, packedOverlay);
    }
}

