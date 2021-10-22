package com.whiteline.votemobs.world.entity;

import com.mojang.datafixers.TypeRewriteRule;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Allay extends Animal implements FlyingAnimal {
    private static final EntityDataAccessor<BlockPos> HOME_POINT = SynchedEntityData.defineId(Allay.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<Integer> COOL_DOWN = SynchedEntityData.defineId(Allay.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DANCE_TIME = SynchedEntityData.defineId(Allay.class, EntityDataSerializers.INT);

    public Allay(EntityType<? extends Allay> allay, Level level){
        super(allay, level);
        this.xpReward = 0;
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.setNoGravity(true);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new Allay.AllaySerchForItemsGoal());
        this.goalSelector.addGoal(2, new Allay.AllayDropCollected());
        this.goalSelector.addGoal(1, new Allay.AllayRandomFlyingGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }

    public void setHomePoint(BlockPos pos){
        this.entityData.set(HOME_POINT, pos);
    }

    public Vec3 getHomePos(){
        return new Vec3(this.entityData.get(HOME_POINT).getX(),this.entityData.get(HOME_POINT).getY(),this.entityData.get(HOME_POINT).getZ());
    }

    public static boolean checkAllaySpawnRules(EntityType<Allay> p_27578_, LevelAccessor p_27579_, MobSpawnType p_27580_, BlockPos p_27581_, Random p_27582_) {
        return true;
    }

        protected SoundEvent getAmbientSound() {
        this.playSound(SoundEvents.GLOW_SQUID_AMBIENT, 2f, 2f);
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource p_28872_) {
        this.playSound(SoundEvents.GLOW_SQUID_HURT, 2f, 2f);
        return null;
    }

    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.GLOW_SQUID_DEATH, 2f, 2f);
        return null;
    }

    public void setCoolDown(){
        this.entityData.set(COOL_DOWN, 200);
    }

    public void dropCollected(ItemStack stack){
        if(!stack.isEmpty() && !this.level.isClientSide){
            LOGGER.info("Dropped");
            ItemEntity itemEntity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getLookAngle().z + this.getZ(), stack);
            itemEntity.setPickUpDelay(40);
            itemEntity.setThrower(this.getUUID());
            this.level.addFreshEntity(itemEntity);
            this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }
    }

    public boolean isOnCoolDown(){
        return (this.entityData.get(COOL_DOWN) > 0);
    }

    public void tick(){
        super.tick();
        if(this.isOnCoolDown()) {
            this.entityData.set(COOL_DOWN, this.entityData.get(COOL_DOWN) - 1);
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);
        if(stack.isEmpty()){
            this.setCoolDown();
            this.dropCollected(this.getItemBySlot(EquipmentSlot.MAINHAND));
            this.dropCollected(this.getItemBySlot(EquipmentSlot.OFFHAND));
            this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }else if(this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()){
            this.setCoolDown();
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(stack.getItem()));
            stack.shrink(1);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }else return super.mobInteract(player, hand);
    }

    public boolean isFlying(){
        return true;
    }

    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob){
        return null;
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.FLYING_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 0).add(Attributes.FOLLOW_RANGE, 20);
    }

    public boolean causeFallDamage(float p_148989_, float p_148990_, DamageSource p_148991_) {
        return false;
    }

    protected void checkFallDamage(double p_29370_, boolean p_29371_, BlockState p_29372_, BlockPos p_29373_) {
    }

    public int getMaxSpawnClusterSize() {
        return 1;
    }

    protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(HOME_POINT, this.getOnPos());
        this.entityData.define(COOL_DOWN, 0);
        this.entityData.define(DANCE_TIME, 0);
    }

    public void setDanceTime(){
        this.entityData.set(DANCE_TIME, 360);
    }

    public void decreaseDanceTime(){
        this.entityData.set(DANCE_TIME, this.entityData.get(DANCE_TIME) - 10);
    }

    public int getDanceTime(){
        return this.entityData.get(DANCE_TIME);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Home_x", this.entityData.get(HOME_POINT).getX());
        tag.putInt("Home_y", this.entityData.get(HOME_POINT).getY());
        tag.putInt("Home_z", this.entityData.get(HOME_POINT).getZ());
        tag.putInt("CoolDown", this.entityData.get(COOL_DOWN));
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (this.level instanceof ServerLevel) {
            this.setHomePoint(new BlockPos(tag.getInt("Home_x"),tag.getInt("Home_y"),tag.getInt("Home_z")));
            this.entityData.set(COOL_DOWN, tag.getInt("CoolDown"));
        }

    }

    public boolean canPickUpLoot(){
        return !this.isOnCoolDown() && this.getItemBySlot(EquipmentSlot.MAINHAND).getCount() < this.getItemBySlot(EquipmentSlot.MAINHAND).getMaxStackSize();
    }

    public boolean canTakeItem(ItemStack stack) {
        EquipmentSlot equipmentslot = EquipmentSlot.MAINHAND;
        if (this.getItemBySlot(equipmentslot).getCount() < this.getItemBySlot(equipmentslot).getMaxStackSize()) {
            return this.canPickUpLoot();
        } else {
            return false;
        }
    }

    public boolean canHoldItem(ItemStack p_28578_) {
        Item item = p_28578_.getItem();
        ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        return itemstack.isEmpty() || itemstack.getItem() == p_28578_.getItem();
    }

    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack itemstack = itemEntity.getItem();
        if (this.canHoldItem(itemstack) && !this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()) {
            LOGGER.info("2");
            int i = itemstack.getCount();
            this.onItemPickup(itemEntity);
            itemstack.grow(this.getItemBySlot(EquipmentSlot.MAINHAND).getCount());
            this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
            this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
            this.take(itemEntity, itemstack.getCount());
            if(itemEntity.getItem().getCount()>=i)
                itemEntity.discard();
            //itemEntity.discard();
        } else LOGGER.info("Can not pickup item");

    }

    public boolean isOnFire(){
        return false;
    }

    public boolean hurt(DamageSource damage, float amount){
        if(damage.isFire()){
            return false;
        }else return super.hurt(damage, amount);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_, @Nullable CompoundTag p_34301_) {
        p_34300_ = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_, p_34301_);
        this.setHomePoint(this.getOnPos());
        return  p_34300_;
    }

    class AllayRandomFlyingGoal extends WaterAvoidingRandomFlyingGoal{
        private static final Logger LOGGER = LogManager.getLogger();

        private final Allay allay;

        public AllayRandomFlyingGoal(Allay allay, double p){
            super(allay, p);
            this.allay = allay;
        }

        //public boolean canUse(){
        //    return this.allay.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty() || this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getCount() == this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getMaxStackSize();
        //}

        @Nullable
        protected Vec3 getPosition(){
            if(this.allay.getPosition(0.1F).distanceTo(this.allay.getHomePos()) < 2.5F){
                if(this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getCount() > 0){
                    this.allay.dropCollected(this.allay.getItemBySlot(EquipmentSlot.MAINHAND));
                    this.allay.setCoolDown();
                }
            }
            if(this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getCount() >= this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getMaxStackSize()-2){
                LOGGER.info("heading_home " + this.allay.getHomePos());
                return allay.getHomePos();
            }else if (this.allay.getPosition(0.1F).distanceTo(this.allay.getHomePos()) > 8){
                LOGGER.info("heading_home " + this.allay.getHomePos());
                return allay.getHomePos();
            }else if (this.allay.getItemBySlot(EquipmentSlot.MAINHAND).getCount() > 0){
                LOGGER.info("heading_home " + this.allay.getHomePos());
                return allay.getHomePos();
            }
            LOGGER.info("heading_somewhere " + super.getPosition());
            return super.getPosition();
        }
    }

    class AllaySerchForItemsGoal extends Goal {
        public AllaySerchForItemsGoal(){
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse(){
            if (Allay.this.isOnCoolDown()){return false;}
            if (Allay.this.getItemBySlot(EquipmentSlot.MAINHAND).getCount() >= Allay.this.getItemBySlot(EquipmentSlot.MAINHAND).getMaxStackSize()-2){
                return false;
            } else if (Allay.this.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()){
                return false;
            } else {
                List<ItemEntity> list = Allay.this.level.getEntitiesOfClass(ItemEntity.class, Allay.this.getBoundingBox().inflate(16.0D, 16.0D, 16.0D), (item) -> item.getItem().getItem() == Allay.this.getItemBySlot(EquipmentSlot.OFFHAND).getItem());
                return !list.isEmpty();
            }
        }

        public void tick(){
            List<ItemEntity> list = Allay.this.level.getEntitiesOfClass(ItemEntity.class, Allay.this.getBoundingBox().inflate(16.0D, 16.0D, 16.0D), (item) -> item.getItem().getItem() == Allay.this.getItemBySlot(EquipmentSlot.OFFHAND).getItem());
            ItemStack itemstack = Allay.this.getItemBySlot(EquipmentSlot.MAINHAND);
            if(itemstack.getCount() < itemstack.getMaxStackSize() && !list.isEmpty()){
                Allay.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }
        }

        public void start(){
            List<ItemEntity> list = Allay.this.level.getEntitiesOfClass(ItemEntity.class, Allay.this.getBoundingBox().inflate(16.0D, 16.0D, 16.0D), (item) -> item.getItem().getItem() == Allay.this.getItemBySlot(EquipmentSlot.OFFHAND).getItem());
            if(!list.isEmpty()){
                Allay.this.getNavigation().moveTo(list.get(0), (double)1.2F);
            }
        }
    }

    class AllayDropCollected extends Goal{
        private static final Logger LOGGER = LogManager.getLogger();

        public AllayDropCollected(){
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse(){
            return !Allay.this.isOnCoolDown() && Allay.this.getHomePos().distanceTo(Allay.this.getPosition(0.1F)) < 2.5F;
        }

        public void start(){
            LOGGER.info("start");
            if(Allay.this.getHomePos().distanceTo(Allay.this.getPosition(0.1F)) < 2.5F){
                Allay.this.setCoolDown();
                Allay.this.dropCollected(Allay.this.getItemBySlot(EquipmentSlot.MAINHAND));
            }
        }
    }
}
