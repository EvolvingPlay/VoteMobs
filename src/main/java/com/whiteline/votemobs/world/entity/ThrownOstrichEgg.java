package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.init.ItemRegistry;
import com.whiteline.votemobs.init.Registry;
import com.whiteline.votemobs.world.items.OstrichEgg;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownOstrichEgg extends ThrowableItemProjectile {

    public ThrownOstrichEgg(Level p_37481_, LivingEntity p_37482_) {
        super(EntityType.EGG, p_37482_, p_37481_);
    }

    public ThrownOstrichEgg(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(EntityType.EGG, p_37477_, p_37478_, p_37479_, p_37476_);
    }

    public ThrownOstrichEgg(EntityType<ThrowableItemProjectile> thrownOstrichEggEntityType, Level level) {
        super(thrownOstrichEggEntityType, level);
    }

    protected void onHitEntity(EntityHitResult p_37486_) {
        super.onHitEntity(p_37486_);
        p_37486_.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            if (this.random.nextInt(16) <= 2) {
                    Ostrich ostrich = Registry.OSTRICH.get().create(this.level);
                    ostrich.setAge(-24000);
                    ostrich.moveTo(this.getX(), this.getY()+1, this.getZ(), this.getYRot(), 0.0F);
                    this.level.addFreshEntity(ostrich);
            }else if (this.random.nextInt(8) <= 2){
                ItemStack stack = new ItemStack(ItemRegistry.OSTRICH_EGG.get(),1);
                ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
                this.level.addFreshEntity(itemEntity);
            }

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();

        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}