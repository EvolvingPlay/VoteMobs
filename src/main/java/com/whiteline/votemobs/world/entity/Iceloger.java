package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.init.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Objects;

public class Iceloger extends SpellcasterIllager {

    public Iceloger(EntityType<? extends SpellcasterIllager> p_33724_, Level p_33725_) {
        super(p_33724_, p_33725_);
        this.xpReward = 10;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.FLYING_SPEED, (double)0.4F).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new IcelogerIceSpellGoal());
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0f));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0f, 10f));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Villager.class, true));

    }

    @Override
    protected SoundEvent getCastingSoundEvent() {
        return null;
    }

    @Override
    public void applyRaidBuffs(int a, boolean b) {

    }

    @Override
    public SoundEvent getCelebrateSound() {
        return null;
    }

    private class IcelogerIceSpellGoal extends SpellcasterIllager.SpellcasterUseSpellGoal {
        public boolean canUse(){
            if (Iceloger.this.isCastingSpell()){
                return false;
            }else if (Iceloger.this.tickCount < this.nextAttackTickCount){
                return false;
            } else return super.canUse();
        }

        public void start(){
            super.start();

        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = Iceloger.this.getTarget();
            return livingentity != null && livingentity.isAlive() && this.attackWarmupDelay > 0;
        }

        public void stop(){
            IcelogerBlocks blocks = Registry.ICELOGERBLOCKS.get().create(Iceloger.this.level);
            blocks.setPos(Iceloger.this.getTarget().getPosition(1.0f).x, Iceloger.this.getTarget().getPosition(1.0f).y + 5,Iceloger.this.getTarget().getPosition(1.0f).z);
            Iceloger.this.level.addFreshEntity(blocks);
            Iceloger.this.setIsCastingSpell(IllagerSpell.NONE);
        }

        @Override
        protected void performSpellCasting() {

        }

        @Override
        protected int getCastingTime() {
            return 100;
        }

        @Override
        protected int getCastingInterval() {
            return 340;
        }

        @Nullable
        @Override
        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.EVOKER_PREPARE_WOLOLO;
        }

        @Override
        protected IllagerSpell getSpell() {
            return IllagerSpell.WOLOLO;
        }
    }
}
