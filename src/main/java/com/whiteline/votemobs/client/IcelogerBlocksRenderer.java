package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Iceloger;
import com.whiteline.votemobs.world.entity.IcelogerBlocks;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IcelogerBlocksRenderer extends MobRenderer<IcelogerBlocks, IcelogerBlocksModel<IcelogerBlocks>> {
    public ResourceLocation getTextureLocation(IcelogerBlocks icelogerblocks) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/iceloger/icelogerblocks.png");
    }

    public IcelogerBlocksRenderer(EntityRendererProvider.Context context) {
        super(context, new IcelogerBlocksModel<>(context.bakeLayer(VoteMobsModelLayers.ICELOGERBLOCKS)), 0.4F);
    }
}
