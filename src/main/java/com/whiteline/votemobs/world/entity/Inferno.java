package com.whiteline.votemobs.world.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.function.Predicate;

public class Inferno extends Blaze {
    private static final Predicate<Entity> NO_BLAZE_AND_ALIVE = (p_33346_) -> {
        return p_33346_.isAlive() && !(p_33346_ instanceof Blaze) && !(p_33346_ instanceof Inferno);
    };
    private int superTick;
    private boolean isPerformingSuper;

    public Inferno(EntityType<? extends Blaze> p_28285_, Level p_28286_) {
        super(p_28285_, p_28286_);
        this.superTick = 0;
    }

    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(3, new InfernoSuperGoal(this));
    }

    public void aiStep(){
        super.aiStep();
        if(this.superTick > 0){
            this.superTick--;
            if(this.superTick == 160){
                this.roar();
            }
        }
    }

    private void roar() {
        if (this.isAlive()) {
            for(LivingEntity livingentity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0D), NO_BLAZE_AND_ALIVE)) {
                if (!(livingentity instanceof AbstractIllager)) {
                    livingentity.hurt(DamageSource.mobAttack(this), 3.0F);
                    livingentity.setSecondsOnFire(4);
                }

                this.strongKnockback(livingentity);
            }

            Vec3 vec3 = this.getBoundingBox().getCenter();

            for(int i = 0; i < 40; ++i) {
                double d0 = this.random.nextGaussian() * 0.2D;
                double d1 = this.random.nextGaussian() * 0.2D;
                double d2 = this.random.nextGaussian() * 0.2D;
                this.level.addParticle(ParticleTypes.FLAME, vec3.x, vec3.y, vec3.z, d0, d1, d2);
            }
        }

    }

    private void strongKnockback(Entity p_33340_) {
        double d0 = p_33340_.getX() - this.getX();
        double d1 = p_33340_.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        p_33340_.push(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
    }

    class InfernoSuperGoal extends Goal{
        private final Inferno inferno;

        public InfernoSuperGoal(Inferno inferno){
            this.inferno = inferno;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public void start() {
            this.inferno.superTick = 200;
            this.inferno.isPerformingSuper = true;
        }

        public void stop(){
            this.inferno.isPerformingSuper = false;
        }

        @Override
        public boolean canUse() {
            LivingEntity livingentity = this.inferno.getTarget();
            return livingentity != null && livingentity.isAlive() && this.inferno.canAttack(livingentity) && this.inferno.superTick==0;
        }
    }
}
