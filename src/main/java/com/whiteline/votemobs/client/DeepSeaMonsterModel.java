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

public class DeepSeaMonsterModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "deep_sea_monster"), "main");
    private final ModelPart spin;

    public DeepSeaMonsterModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = spin.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, 4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition jaw_R_U = head.addOrReplaceChild("jaw_R_U", CubeListBuilder.create().texOffs(60, 16).mirror().addBox(-3.0F, -3.0F, -24.0F, 6.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -7.0F, -3.0F));

        PartDefinition jaw_L_U = head.addOrReplaceChild("jaw_L_U", CubeListBuilder.create().texOffs(60, 16).addBox(-3.0F, -3.0F, -24.0F, 6.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -7.0F, -3.0F));

        PartDefinition jaw_L_D = head.addOrReplaceChild("jaw_L_D", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -24.0F, 6.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.0F, -3.0F));

        PartDefinition jaw_R_D = head.addOrReplaceChild("jaw_R_D", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-3.0F, -3.0F, -24.0F, 6.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -1.0F, -3.0F));

        PartDefinition tentacles = head.addOrReplaceChild("tentacles", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -1.0F, -30.0F, 0.0F, 2.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        spin.render(poseStack, buffer, packedLight, packedOverlay);
    }
}