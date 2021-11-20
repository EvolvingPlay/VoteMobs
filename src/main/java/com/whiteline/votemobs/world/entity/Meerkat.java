package com.whiteline.votemobs.world.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class Meerkat extends TamableAnimal {
    public Meerkat(EntityType<? extends TamableAnimal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new FollowOwnerGoal(this, 1.0d, 5.0f, 2.0f, false));
        this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 1.0f, 6.0f));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5f, true));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(4, new PanicGoal(this, 2.0f));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Spider.class, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, CaveSpider.class, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Bee.class, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Termite.class, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Silverfish.class, false));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Endermite.class, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MOVEMENT_SPEED, (double)0.3F).add(Attributes.FOLLOW_RANGE, 20.0D);
    }



    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
}
