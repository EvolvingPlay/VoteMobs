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

public class EternalHungerModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "eternal_hunger"), "main");
    private final ModelPart spin;

    public EternalHungerModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(37, 17).addBox(-3.5F, 0.0F, -1.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.5F, -3.0F, -5.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(35, 0).addBox(-4.5F, -1.0F, -5.0F, 9.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 29).addBox(-4.5F, -3.0F, -11.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(0.1F))
                .texOffs(0, 14).addBox(-4.5F, -3.0F, -11.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(35, 0).addBox(-4.5F, -2.0F, -11.0F, 9.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(-4.5F, -3.0F, -11.0F, 9.0F, 3.0F, 11.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -3.0F, 6.0F));

        PartDefinition leg_L1 = body.addOrReplaceChild("leg_L1", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, 0.5F));

        PartDefinition leg_R1 = body.addOrReplaceChild("leg_R1", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.0F, 0.5F));

        PartDefinition leg_L2 = body.addOrReplaceChild("leg_L2", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, 4.5F));

        PartDefinition leg_R2 = body.addOrReplaceChild("leg_R2", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.0F, 4.5F));

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
