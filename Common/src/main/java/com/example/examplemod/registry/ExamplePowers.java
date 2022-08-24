package com.example.examplemod.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.platform.Services;
import com.example.examplemod.power.HoverPower;
import com.example.examplemod.power.data.HoverPowerData;
import io.github.apace100.apoli.power.factory.PowerFactory;
import net.minecraft.resources.ResourceLocation;

public class ExamplePowers {
    public static final PowerFactory<HoverPower> HOVER = Services.PLATFORM.registerPowerFactory(new ResourceLocation(Constants.MOD_ID, "hover"), new HoverPowerData());

    public static void init() {

    }
}
