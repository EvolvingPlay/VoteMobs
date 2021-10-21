package com.whiteline.votemobs.world.entity;

import com.mojang.authlib.GameProfile;
import com.whiteline.votemobs.VoteMobs;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.FakePlayer;
import org.openjdk.nashorn.internal.ir.Block;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CopperGolem extends AbstractGolem {
    protected static final EntityDataAccessor<Integer> OXIDIZE = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> OXIDIZE_TIMER = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Float> ROTATE_HEAD = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.FLOAT);
    protected static final EntityDataAccessor<Integer> COOL_DOWN = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.INT);
    private int attackAnimationTick;

    public CopperGolem(EntityType<? extends CopperGolem> golem, Level level){
        super(golem, level);
        this.maxUpStep = 0.5F;
        this.attackAnimationTick = 0;
    }

    protected  void registerGoals(){
        this.goalSelector.addGoal(0, new GoToButton(this, 1.25D));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this){
            @Override
            public boolean canUse() {
                if (CopperGolem.this.getOxidize() == 3){
                    return false;
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F){
            @Override
            public boolean canUse() {
                if (CopperGolem.this.getOxidize() == 3){
                    return false;
                }
                return super.canUse();
            }
        });
        this.goalSelector.addGoal(3, new PressNearbyButtons(this));
    }

    public int getOxidize(){
        return this.entityData.get(OXIDIZE);
    }

    public float getHeadRotate(){
        return this.entityData.get(ROTATE_HEAD);
    }

    public boolean isOnCooldown(){
        return this.entityData.get(COOL_DOWN) > 0;
    }

    public void removeOxide(){
        if (this.getOxidize() > 0){
            this.entityData.set(OXIDIZE, this.getOxidize() - 1);
            this.level.addParticle(ParticleTypes.SCRAPE, this.getX() - 0.1D, this.getY() + 0.1D, this.getZ() + 0.2D, 0.5, 0.5, 0.5);
            this.level.addParticle(ParticleTypes.SCRAPE, this.getX() + 0.2D, this.getY() + 0.3D, this.getZ() + 0.5D, 0.5, 0.5, 0.5);
            this.level.addParticle(ParticleTypes.SCRAPE, this.getX() + 0.1D, this.getY() + 0.5D, this.getZ() - 0.3D, 0.5, 0.5, 0.5);
            this.level.addParticle(ParticleTypes.SCRAPE, this.getX() - 0.3D, this.getY() + 0.9D, this.getZ() + 0.1D, 0.5, 0.5, 0.5);
            this.level.addParticle(ParticleTypes.SCRAPE, this.getX() + 0.2D, this.getY() + 0.4D, this.getZ() + 0.3D, 0.5, 0.5, 0.5);
            this.playSound(SoundEvents.AXE_SCRAPE, 1.0F, 1.0F);
        }
    }

    public ResourceLocation getOxidizeTexture(){
        return new ResourceLocation(VoteMobs.MOD_ID, "textures/entity/copper_golem/copper_golem" + this.getOxidize() + ".png");
    }

    protected void dropCustomDeathLoot(DamageSource p_21385_, int p_21386_, boolean p_21387_) {
        super.dropCustomDeathLoot(p_21385_, p_21386_, p_21387_);

        this.spawnAtLocation(new ItemStack(Items.COPPER_INGOT, 4));

    }

    protected PathNavigation createNavigation(Level p_29417_) {
        GroundPathNavigation pathNavigation = new GroundPathNavigation(this, p_29417_);
        pathNavigation.setCanOpenDoors(false);
        pathNavigation.setCanFloat(false);
        return pathNavigation;
    }

    protected void defineSynchedData(){
        super.defineSynchedData();
        this.entityData.define(OXIDIZE, 0);
        this.entityData.define(OXIDIZE_TIMER, 24000);
        this.entityData.define(COOL_DOWN, 20);
        this.entityData.define(ROTATE_HEAD, 0f);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Oxidize", this.entityData.get(OXIDIZE));
        tag.putInt("Oxidize_Timer", this.entityData.get(OXIDIZE_TIMER));
        tag.putInt("Cool_Down", this.entityData.get(COOL_DOWN));
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (this.level instanceof ServerLevel) {
            this.entityData.set(OXIDIZE, tag.getInt("Oxidize"));
            this.entityData.set(OXIDIZE_TIMER, tag.getInt("Oxidize_Timer"));
            this.entityData.set(COOL_DOWN, tag.getInt("Cool_Down"));
        }

    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.KNOCKBACK_RESISTANCE, 0.7D);
    }

    public int getAttackAnimationTick() {
        return this.entityData.get(COOL_DOWN) - 10;
    }

    public void aiStep(){
        super.aiStep();
    }

    public void tick(){
        super.tick();
        if(this.entityData.get(OXIDIZE) < 3){
            if(this.entityData.get(OXIDIZE_TIMER) == 0){
                this.entityData.set(OXIDIZE, this.entityData.get(OXIDIZE) + 1);
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3f - this.getOxidize()/10);
                this.entityData.set(OXIDIZE_TIMER, 24000);
            }else this.entityData.set(OXIDIZE_TIMER, this.entityData.get(OXIDIZE_TIMER) - 1);
        }
        if(this.getHeadRotate() > 0){
            this.entityData.set(ROTATE_HEAD, this.getHeadRotate() - 0.05F);
        }
        if(this.isOnCooldown()){
            this.entityData.set(COOL_DOWN, this.entityData.get(COOL_DOWN) - 1);
        }
        if (this.random.nextInt(200) < 2 && this.getHeadRotate() <= 0.5F){
            this.entityData.set(ROTATE_HEAD, 1F);
        }
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }
    protected SoundEvent getAmbientSound() {
        return Registry.COPPER_GOLEM_AMBIENT.get();
    }

    public void thunderHit(ServerLevel p_32286_, LightningBolt p_32287_) {
        super.thunderHit(p_32286_, p_32287_);
        if(this.getOxidize() > 0) {
            this.entityData.set(OXIDIZE, this.entityData.get(OXIDIZE) - 1);
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_28872_) {
        this.playSound(SoundEvents.IRON_GOLEM_HURT, 2f, 2f);
        return null;
    }

    protected SoundEvent getDeathSound() {
        this.playSound(SoundEvents.IRON_GOLEM_DEATH, 2f, 2f);
        return null;
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);
        if(this.getOxidize() > 0 && stack.getItem().getClass().isAssignableFrom(AxeItem.class) && stack.getItem().getDefaultInstance().isCorrectToolForDrops(Blocks.OAK_FENCE.defaultBlockState())){
            stack.setDamageValue(stack.getDamageValue()+1);
            this.removeOxide();
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }else return super.mobInteract(player, hand);
    }

    class GoToButton extends WaterAvoidingRandomStrollGoal{
        private CopperGolem golem;
        List<BlockPos> list = new ArrayList<BlockPos>();

        public GoToButton(CopperGolem golem, double p){
            super(golem, p);
            this.golem = golem;
        }

        public boolean canUse(){
            if(golem.getOxidize() == 3){
                return false;
            }
            else return super.canUse();
        }

        @Nullable
        protected Vec3 getPosition() {
            if (!CopperGolem.this.isOnCooldown()){
                for (int i = -8; i <= 8; i++){
                    for (int j = -8; j <= 8; j++){
                        for (int k = 0; k <= 1; k++){
                            if (golem.level.getBlockState(golem.getOnPos().offset(i,k,j)).getBlock() == Blocks.OAK_BUTTON){
                                list.add(golem.getOnPos().offset(i,k,j));
                            }
                        }
                    }
                }
                if(list.size()-1>0){
                    return Vec3.atCenterOf(list.get(golem.random.nextInt(list.size()-1)));
                }else if(list.size()>0){
                    return Vec3.atCenterOf(list.get(golem.random.nextInt(list.size())));
                }
            }
            return super.getPosition();
        }
    }

    class PressNearbyButtons extends Goal{
        private ServerLevel level;
        private CopperGolem golem;
        private FakePlayer player;
        GameProfile CopperGolem = new GameProfile(UUID.randomUUID(), "Test");

        List<BlockPos> list = new ArrayList<BlockPos>();

        public PressNearbyButtons(CopperGolem golem){
            this.golem = golem;
            this.level = golem.getServer().getLevel(golem.level.dimension());
            this.player = new FakePlayer(this.level.getLevel(),CopperGolem);
        }

        public boolean canUse(){
            if (golem.getOxidize() == 3){
                return false;
            }
            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    for (int k = -2; k <= 2; k++){
                        if (this.level.getBlockState(golem.getOnPos().offset(i,k,j)).getBlock() == Registry.COPPER_BUTTON.get()){
                            list.add(golem.getOnPos().offset(i,k,j));
                        }
                    }
                }
            }
            return  !list.isEmpty() && !CopperGolem.this.isOnCooldown();
        }

        public boolean canContinueToUse(){
            return false;
        }

        public void tick(){
            for (BlockPos pos: list) {
                if(this.golem.random.nextInt(10) < 2){
                    this.level.getBlockState(pos).use(this.golem.level, player, InteractionHand.MAIN_HAND, new BlockHitResult(Vec3.ZERO, Direction.DOWN,pos, false));
                    break;
                }
            }
            CopperGolem.this.attackAnimationTick = 10;
            golem.entityData.set(COOL_DOWN, 20);
            list.clear();
        }
    }
}
