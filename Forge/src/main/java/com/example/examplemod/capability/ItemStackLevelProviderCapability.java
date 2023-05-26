package com.example.examplemod.capability;

import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemStackLevelProviderCapability implements IItemStackLevelProviderCapability, ICapabilityProvider {
    private Level level;

    public static final Capability<ItemStackLevelProviderCapability> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
    private final LazyOptional<ItemStackLevelProviderCapability> thisOptional = LazyOptional.of(() -> this);

    public ItemStackLevelProviderCapability() {
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ItemStackLevelProviderCapability.INSTANCE.orEmpty(cap, thisOptional);
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public void setLevel(Level value) {
        this.level = value;
    }
}