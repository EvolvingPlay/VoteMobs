package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.init.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.*;
import java.util.function.Predicate;

public class Glare extends Animal implements FlyingAnimal {
    private static final EntityDataAccessor<Boolean> DATA_IS_ANGRY = SynchedEntityData.defineId(Glare.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> INTEREST = SynchedEntityData.defineId(Glare.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<UUID>> PLAYER = SynchedEntityData.defineId(Glare.class, EntityDataSerializers.OPTIONAL_UUID);

    public Glare(EntityType<? extends Glare> glare, Level level){
        super(glare, level);
        this.xpReward = 0;
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.setNoGravity(true);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new Glare.FloatToDarkArea(this, 2D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }

    public static boolean checkGlareSpawnRules(EntityType<Glare> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return p_27581_.getY() < 40;
    }

    public void aiStep(){
        super.aiStep();
    }

    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_) {
        super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);

        this.spawnAtLocation(new ItemStack(Items.GLOW_BERRIES, 2));

    }



    public void tick(){
        super.tick();
        if (isInterested()){
            this.entityData.set(INTEREST, this.entityData.get(INTEREST) - 1);
        }
    }

    public boolean causeFallDamage(float p_148989_, float p_148990_, DamageSource p_148991_) {
        return false;
    }

    protected void checkFallDamage(double p_29370_, boolean p_29371_, BlockState p_29372_, BlockPos p_29373_) {
    }

    public boolean isAngry(){
        return this.entityData.get(DATA_IS_ANGRY);
    }

    public void setAngry(boolean is_angry) {
        this.entityData.set(DATA_IS_ANGRY, is_angry);
    }

    public boolean isInterested(){
        return this.entityData.get(INTEREST) > 0;
    }

    public int getMaxSpawnClusterSize() {
        return 1;
    }

    public boolean isFlying(){
        return true;
    }

    protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob){
        return null;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand){
        ItemStack itemstack = player.getItemInHand(hand);
        if(itemstack.is(Items.GLOW_BERRIES)){
            this.level.broadcastEntityEvent(this, (byte)18);
            this.entityData.set(INTEREST, this.entityData.get(INTEREST) + 1000);
            itemstack.shrink(1);
            this.entityData.set(PLAYER, Optional.ofNullable(player.getUUID()));
            return InteractionResult.SUCCESS;
        }
        else return super.mobInteract(player, hand);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.FLYING_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 0).add(Attributes.FOLLOW_RANGE, 20);
    }

    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(DATA_IS_ANGRY, false);
        this.entityData.define(INTEREST, 5000);
        this.entityData.define(PLAYER, Optional.empty());
    }

    protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.SHULKER_AMBIENT, 2f, 2f);
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource p_28872_) {
        this.playSound(SoundEvents.SHULKER_HURT, 2f, 2f);
        return null;
    }


    class FloatToDarkArea extends WaterAvoidingRandomFlyingGoal{
        private static final Logger LOGGER = LogManager.getLogger();
        private final Glare glare;

        public FloatToDarkArea(Glare glare, double p){
            super(glare, p);
            this.glare = glare;
        }

        @Nullable
        protected Vec3 getPosition() {
            Level level = this.glare.level;

            List<BlockPos> reachable = new ArrayList<BlockPos>();
            List<BlockPos> visited = new ArrayList<BlockPos>();

            reachable.add(this.glare.blockPosition());

            int i = 0;
            Vec3 player_pos;
            try{
                player_pos = Glare.this.level.getPlayerByUUID(Glare.this.entityData.get(PLAYER).get()).getPosition(0.1f);
            }catch (Exception e){
                player_pos = Glare.this.getPosition(0.1f);
            }
            while (i < 360 && !reachable.isEmpty() && Glare.this.isInterested() && Glare.this.position().distanceTo(player_pos) < 7) {
                BlockPos pos = reachable.get(0);
                if (level.getBlockState(pos).getBlock() != Blocks.AIR){
                    reachable.remove(0);
                }else if(level.getBrightness(LightLayer.BLOCK, pos) < 8 && level.getBrightness(LightLayer.SKY, pos) < 8){
                    this.glare.setAngry(true);
                    LOGGER.info("sucsess");
                    return Vec3.atBottomCenterOf(pos).add(new Vec3(0, 1, 0));
                } else {
                    visited.add(pos);
                    reachable.remove(0);
                    if(!visited.contains(pos.above())){
                        reachable.add(pos.above());
                    }
                    if(!visited.contains(pos.below())){
                        reachable.add(pos.below());
                    }
                    if(!visited.contains(pos.north())){
                        reachable.add(pos.north());
                    }
                    if(!visited.contains(pos.south())){
                        reachable.add(pos.south());
                    }
                    if(!visited.contains(pos.west())){
                        reachable.add(pos.west());
                    }
                    if(!visited.contains(pos.east())){
                        reachable.add(pos.east());
                    }
                }
                i++;
            }
            this.glare.setAngry(false);
            if(isInterested()){
                try {
                    return Glare.this.level.getPlayerByUUID(Glare.this.entityData.get(PLAYER).get()).getPosition(0.1f).add(new Vec3(0, 1, 0));
                } catch (Exception e){
                    Vec3 pos = super.getPosition();
                    return pos == null ? null : pos.add(new Vec3(0, 1, 0));
                }
            }
            LOGGER.info("fail");
            Vec3 pos = super.getPosition();
            return pos == null ? null : pos.add(new Vec3(0, 1, 0));
        }
    }
}
