package com.example.examplemod.access;

import net.minecraft.world.level.Level;

public interface ItemStackLevelAccess {
    
    Level getLevel();
    
    void setLevel(Level value);
    
}
