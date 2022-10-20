package com.example.examplemod.registry;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.registry.services.RegistrationProvider;
import io.github.edwinmindcraft.apoli.api.power.factory.*;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;

public class ExampleModRegisters {
    
    public static final RegistrationProvider<PowerFactory<?>> POWER_FACTORIES = RegistrationProvider.get(ApoliRegistries.POWER_FACTORY_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<BiEntityCondition<?>> BIENTITY_CONDITIONS = RegistrationProvider.get(ApoliRegistries.BIENTITY_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<BiomeCondition<?>> BIOME_CONDITIONS = RegistrationProvider.get(ApoliRegistries.BIOME_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<BlockCondition<?>> BLOCK_CONDITIONS = RegistrationProvider.get(ApoliRegistries.BLOCK_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<DamageCondition<?>> DAMAGE_CONDITIONS = RegistrationProvider.get(ApoliRegistries.DAMAGE_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<EntityCondition<?>> ENTITY_CONDITIONS = RegistrationProvider.get(ApoliRegistries.ENTITY_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<FluidCondition<?>> FLUID_CONDITIONS = RegistrationProvider.get(ApoliRegistries.FLUID_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<ItemCondition<?>> ITEM_CONDITIONS = RegistrationProvider.get(ApoliRegistries.ITEM_CONDITION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<BiEntityAction<?>> BIENTITY_ACTIONS = RegistrationProvider.get(ApoliRegistries.BIENTITY_ACTION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<BlockAction<?>> BLOCK_ACTIONS = RegistrationProvider.get(ApoliRegistries.BLOCK_ACTION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<EntityAction<?>> ENTITY_ACTIONS = RegistrationProvider.get(ApoliRegistries.ENTITY_ACTION_KEY, ExampleMod.MOD_ID);
    
    public static final RegistrationProvider<ItemAction<?>> ITEM_ACTIONS = RegistrationProvider.get(ApoliRegistries.ITEM_ACTION_KEY, ExampleMod.MOD_ID);
    
}