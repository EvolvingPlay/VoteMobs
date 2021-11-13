package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.Frog;
import com.whiteline.votemobs.world.entity.Tadpole;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TadpoleRenderer extends MobRenderer<Tadpole, TadpoleModel<Tadpole>> {
    public ResourceLocation getTextureLocation(Tadpole tadpole) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/tadpole/tadpole.png");
    }

    public TadpoleRenderer(EntityRendererProvider.Context context) {
        super(context, new TadpoleModel<>(context.bakeLayer(VoteMobsModelLayers.TADPOLE)), 0.4F);
    }
}
