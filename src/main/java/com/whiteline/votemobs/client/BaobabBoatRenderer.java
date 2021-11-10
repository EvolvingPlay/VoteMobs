package com.whiteline.votemobs.client;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BaobabBoatRenderer extends EntityRenderer<Boat> {
    protected BaobabBoatRenderer(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Override
    public ResourceLocation getTextureLocation(Boat p_114482_) {
        return null;
    }

    public static enum Type {
        BAOBAB(Blocks.OAK_PLANKS, "oak"),
        PALM(Blocks.SPRUCE_PLANKS, "spruce"),

        private final String name;
        private final Block planks;

        private Type(Block p_38427_, String p_38428_) {
            this.name = p_38428_;
            this.planks = p_38427_;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Boat.Type byId(int p_38431_) {
            Boat.Type[] aboat$type = values();
            if (p_38431_ < 0 || p_38431_ >= aboat$type.length) {
                p_38431_ = 0;
            }

            return aboat$type[p_38431_];
        }

        public static Boat.Type byName(String p_38433_) {
            Boat.Type[] aboat$type = values();

            for(int i = 0; i < aboat$type.length; ++i) {
                if (aboat$type[i].getName().equals(p_38433_)) {
                    return aboat$type[i];
                }
            }

            return aboat$type[0];
        }
    }

}
