package com.whiteline.votemobs.client;

import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.world.entity.DeepSeaMonster;
import com.whiteline.votemobs.world.entity.EternalHunger;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeepSeaMonsterRenderer extends MobRenderer<DeepSeaMonster, DeepSeaMonsterModel<DeepSeaMonster>> {
    public ResourceLocation getTextureLocation(DeepSeaMonster deepseamonster) {
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/deep_sea_monster/deep_sea_monster.png");
    }

    public DeepSeaMonsterRenderer(EntityRendererProvider.Context context) {
        super(context, new DeepSeaMonsterModel<>(context.bakeLayer(VoteMobsModelLayers.DEEPSEAMONSTER)), 0.4F);
    }
}
