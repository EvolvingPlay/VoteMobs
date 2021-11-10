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

public class OstrichModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "ostrich"), "main");
    private final ModelPart spin;

    public OstrichModel(ModelPart root) {
        this.spin = root.getChild("spin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spin = partdefinition.addOrReplaceChild("spin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = spin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(8, 37).addBox(-5.5F, -10.0F, -9.0F, 11.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(2, 27).addBox(-2.5F, -17.0F, -5.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(-2.5F, -19.0F, -3.0F, 5.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -9.0F));

        PartDefinition leg_R = body.addOrReplaceChild("leg_R", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-2.0F, -0.01F, -7.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 0.0F, 1.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(46, 0).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 9.0F));

        PartDefinition leg_L = body.addOrReplaceChild("leg_L", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, -0.01F, -7.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 0.0F, 1.0F));

        PartDefinition wing_L = body.addOrReplaceChild("wing_L", CubeListBuilder.create().texOffs(34, 15).addBox(0.0F, -2.0F, -2.0F, 2.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -7.0F, -1.0F));

        PartDefinition wing_R = body.addOrReplaceChild("wing_R", CubeListBuilder.create().texOffs(34, 15).mirror().addBox(-2.0F, -2.0F, -2.0F, 2.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, -7.0F, -1.0F));

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
