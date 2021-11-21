package com.whiteline.votemobs.world.entity;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class IcelogerBlocks extends Mob {
    public int fall_timer;

    public IcelogerBlocks(EntityType<? extends IcelogerBlocks> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.setNoGravity(true);
        this.setInvulnerable(true);
        fall_timer = 0;
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    public void tick(){
        super.tick();
        if(fall_timer<40){
            fall_timer++;
        }else this.setNoGravity(false);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.FLYING_SPEED, (double)0.4F).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }

    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        if (this.isAlive()) {
            for (LivingEntity livingentity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5D))) {
                if (!(livingentity instanceof AbstractIllager)) {
                    livingentity.hurt(DamageSource.mobAttack(this), 10.0F);
                    livingentity.setTicksFrozen(240);
                }
            }

            Vec3 vec3 = this.getBoundingBox().getCenter();

            for (int i = 0; i < 40; ++i) {
                double d0 = this.random.nextGaussian() * 0.2D;
                double d1 = this.random.nextGaussian() * 0.2D;
                double d2 = this.random.nextGaussian() * 0.2D;
                this.level.addParticle(ParticleTypes.SNOWFLAKE, vec3.x, vec3.y, vec3.z, d0, d1, d2);
            }

            this.remove(RemovalReason.KILLED);
        }

        return false;
    }
}
