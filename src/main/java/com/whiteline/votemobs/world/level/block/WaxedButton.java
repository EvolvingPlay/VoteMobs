package com.whiteline.votemobs.world.level.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.ButtonBlock;

public class WaxedButton extends ButtonBlock {
    public WaxedButton(boolean b, Properties properties) {
        super(b, properties);
    }

    @Override
    protected SoundEvent getSound(boolean b) {
        return null;
    }
}
