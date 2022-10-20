package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.registry.services.RegistrationProvider;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;

public class ExampleModRegisters {
    
    public static final RegistrationProvider<PowerFactory> POWER_FACTORIES = RegistrationProvider.get(ApoliRegistries.POWER_FACTORY, ExampleMod.MOD_ID);

}