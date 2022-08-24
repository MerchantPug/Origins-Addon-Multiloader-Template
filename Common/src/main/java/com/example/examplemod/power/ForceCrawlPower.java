package com.example.examplemod.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.world.entity.LivingEntity;

public class ForceCrawlPower extends Power {
    public ForceCrawlPower(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }
}
