package com.whiteline.votemobs.world.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class Iceloger extends SpellcasterIllager {

    protected Iceloger(EntityType<? extends SpellcasterIllager> p_33724_, Level p_33725_) {
        super(p_33724_, p_33725_);
        this.xpReward = 10;
    }

    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
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
