package com.whiteline.votemobs.client;


import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Moobloom;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class MoobloomRenderer extends MobRenderer<Moobloom, MoobloomModel<Moobloom>> {

    public ResourceLocation getTextureLocation(Moobloom moobloom) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/moobloom/moobloom.png");
    }

    public MoobloomRenderer(EntityRendererProvider.Context context) {
        super(context, new MoobloomModel<>(context.bakeLayer(VoteMobsModelLayers.MOOBLOOM)), 0.4F);
    }
}
