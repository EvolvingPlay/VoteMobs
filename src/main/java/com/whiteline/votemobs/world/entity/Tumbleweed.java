package com.whiteline.votemobs.world.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Tumbleweed extends Animal {
    public Tumbleweed(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new RandomRollAround(this, 1.0, 1, true));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    class RandomRollAround extends Goal {
        public static final int DEFAULT_INTERVAL = 120;
        protected final PathfinderMob mob;
        protected double wantedX;
        protected double wantedY;
        protected double wantedZ;
        protected final double speedModifier;
        protected int interval;
        protected boolean forceTrigger;
        private final boolean checkNoActionTime;

        public RandomRollAround(PathfinderMob p_25741_, double p_25742_, int p_25743_, boolean p_25744_) {
            this.mob = p_25741_;
            this.speedModifier = p_25742_;
            this.interval = p_25743_;
            this.checkNoActionTime = p_25744_;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
            if (this.mob.isVehicle()) {
                return false;
            } else {
                if (!this.forceTrigger) {
                    if (this.checkNoActionTime && this.mob.getNoActionTime() >= 100) {
                        return false;
                    }

                    if (this.mob.getRandom().nextInt(this.interval) != 0) {
                        return false;
                    }
                }

                Vec3 vec3 = this.getPosition();
                if (vec3 == null) {
                    return false;
                } else {
                    this.wantedX = vec3.x*10;
                    this.wantedY = vec3.y;
                    this.wantedZ = vec3.z*10;
                    this.forceTrigger = false;
                    return true;
                }
            }
        }

        @Nullable
        protected Vec3 getPosition() {
            return DefaultRandomPos.getPos(this.mob, 100, 100);
        }

        public boolean canContinueToUse() {
            return !this.mob.getNavigation().isDone() && !this.mob.isVehicle();
        }

        public void start() {
            this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        public void stop() {
            this.mob.getNavigation().stop();
            super.stop();
        }

        public void trigger() {
            this.forceTrigger = true;
        }

        public void setInterval(int p_25747_) {
            this.interval = p_25747_;
        }
    }
}
