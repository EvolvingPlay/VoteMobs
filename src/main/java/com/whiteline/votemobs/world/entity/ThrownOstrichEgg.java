package com.whiteline.votemobs.world.entity;

import com.whiteline.votemobs.init.Registry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownOstrichEgg extends ThrownEgg {
    public ThrownOstrichEgg(EntityType<? extends ThrownEgg> p_37473_, Level p_37474_) {
        super(p_37473_, p_37474_);
    }

    protected void onHitEntity(EntityHitResult p_37486_) {
        super.onHitEntity(p_37486_);
        p_37486_.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for (int j = 0; j < i; ++j) {
                    Ostrich ostrich = Registry.OSTRICH.get().create(this.level);
                    ostrich.setAge(-24000);
                    ostrich.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level.addFreshEntity(ostrich);
                }
            }

        }
    }
}