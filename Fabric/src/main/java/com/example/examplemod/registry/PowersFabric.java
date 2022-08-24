package com.example.examplemod.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.registry.services.RegistrationProvider;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;

public class PowersFabric {
    public static final RegistrationProvider<PowerFactory> POWER_FACTORY_REGISTRY = RegistrationProvider.get(ApoliRegistries.POWER_FACTORY, Constants.MOD_ID);
}