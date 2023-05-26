package com.example.examplemod.capability;

import com.example.examplemod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public interface IItemStackLevelProviderCapability {
    ResourceLocation ID = ExampleMod.asResource("item_stack_level_provider");

    Level getLevel();
    void setLevel(Level value);
}