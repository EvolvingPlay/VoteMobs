package com.whiteline.votemobs.client;

// Made with Blockbench 4.0.4
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

public class FrogModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "frog"), "main");
    private final ModelPart spin;

    public FrogModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.5F, -4.0F, -4.5F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(23, 18).addBox(-3.5F, -3.01F, -4.5F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_mouth = body.addOrReplaceChild("body_mouth", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -2.0F, -2.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -3.0F));

        PartDefinition tongue = body.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(47, 0).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 4.0F));

        PartDefinition back_left_leg = body.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(23, 0).addBox(2.5F, -3.0F, 1.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(-4, 12).addBox(4.5F, 0.0F, 0.5F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition front_left_leg = body.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(32, 7).addBox(3.0F, -3.0F, -4.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(-4, 0).addBox(1.0F, 0.0F, -6.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition front_right_leg = body.addOrReplaceChild("front_right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition front_right_leg_sub_0 = front_right_leg.addOrReplaceChild("front_right_leg_sub_0", CubeListBuilder.create().texOffs(42, 7).addBox(-5.0F, -3.0F, -4.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(-4, 0).mirror().addBox(-5.0F, 0.0F, -6.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_right_leg = body.addOrReplaceChild("back_right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition back_right_leg_sub_0 = back_right_leg.addOrReplaceChild("back_right_leg_sub_0", CubeListBuilder.create().texOffs(37, 0).addBox(-5.5F, -3.0F, 1.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(-4, 12).mirror().addBox(-7.5F, 0.0F, 0.5F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 9.0F, new CubeDeformation(0.001F))
                .texOffs(23, 18).addBox(-3.5F, -1.0F, -7.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(23, 13).addBox(0.5F, -4.0F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(35, 13).addBox(-3.5F, -4.0F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 2.5F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        spin.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
