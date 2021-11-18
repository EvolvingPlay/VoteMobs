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

public class MeerkatModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "meerkat"), "main");
    private final ModelPart spin;

    public MeerkatModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(12, 25).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 46).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 46).mirror().addBox(-6.0F, -3.0F, -2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 46).addBox(4.0F, -3.0F, -2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.0F));

        PartDefinition leg_L = body.addOrReplaceChild("leg_L", CubeListBuilder.create().texOffs(18, 28).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.0F, -3.0F));

        PartDefinition leg_R = body.addOrReplaceChild("leg_R", CubeListBuilder.create().texOffs(18, 28).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -1.0F, -3.0F));

        PartDefinition leg1_R = body.addOrReplaceChild("leg1_R", CubeListBuilder.create().texOffs(38, 30).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(50, 33).mirror().addBox(-1.0F, 3.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 1.0F, 5.5F));

        PartDefinition leg1_L = body.addOrReplaceChild("leg1_L", CubeListBuilder.create().texOffs(38, 30).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(50, 33).mirror().addBox(-1.0F, 3.0F, -3.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 1.0F, 5.5F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(15, 8).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 7.0F));

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
