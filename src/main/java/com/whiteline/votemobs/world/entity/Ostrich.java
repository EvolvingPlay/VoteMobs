package com.whiteline.votemobs.world.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;

import javax.annotation.Nullable;

public class Ostrich extends AbstractChestedHorse {
    public Ostrich(EntityType<? extends AbstractChestedHorse> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    protected void playGallopSound(SoundType p_30709_) {

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, (double)0.5F);
    }

    public boolean canEatGrass() {
        return false;
    }

    public double getPassengersRidingOffset() {
        return (double)this.getBbHeight() * 0.5D;
    }

}
