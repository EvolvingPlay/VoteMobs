package com.whiteline.votemobs.world.level.block;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.whiteline.votemobs.init.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class CopperButton extends ButtonBlock implements WeatheringButton {
    private final WeatheringCopper.WeatherState weatherState;

    public CopperButton(boolean b, Properties properties, WeatheringCopper.WeatherState state) {
        super(b, properties);
        this.weatherState = state;
    }

    @Override
    public void randomTick(BlockState p_154929_, ServerLevel p_154930_, BlockPos p_154931_, Random p_154932_) {
        this.onRandomTick(p_154929_, p_154930_, p_154931_, p_154932_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_) {
        return WeatheringButton.getNext(p_154935_.getBlock()).isPresent();
    }

    @Override
    protected SoundEvent getSound(boolean p_51102_) {
        return null;
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }

}
