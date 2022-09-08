package com.example.examplemod.platform.services;

import com.example.examplemod.action.IActionData;
import com.example.examplemod.condition.IConditionData;
import com.example.examplemod.power.data.IPowerData;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableDataType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.Tuple;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.material.FluidState;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Registers a power type based on name and a power factory.
     *
     * @return The registered power
     */
    <P extends Power> PowerFactory<P> registerPowerFactory(String name, IPowerData<P> power);

    <P extends Power> List<P> getPowers(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory);

    <P extends Power> boolean hasPower(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory);

    void registerBiEntityCondition(String name, IConditionData<Tuple<Entity, Entity>> condition);
    
    SerializableDataType<?> getBiEntityConditionDataType();
    
    void registerBiomeCondition(String name, IConditionData<Holder<Biome>> condition);

    SerializableDataType<?> getBiomeConditionDataType();
    
    void registerBlockCondition(String name, IConditionData<BlockInWorld> condition);

    SerializableDataType<?> getBlockConditionDataType();
    
    void registerDamageCondition(String name, IConditionData<Tuple<DamageSource, Float>> condition);

    SerializableDataType<?> getDamageConditionDataType();
    
    void registerEntityCondition(String name, IConditionData<Entity> condition);

    SerializableDataType<?> getEntityConditionDataType();
    
    void registerFluidCondition(String name, IConditionData<FluidState> condition);

    SerializableDataType<?> getFluidConditionDataType();
    
    void registerItemCondition(String name, IConditionData<ItemStack> condition);

    SerializableDataType<?> getItemConditionDataType();
    
    void registerBiEntityActionFactory(String name, IActionData<Tuple<Entity, Entity>> action);
    
    SerializableDataType<?> getBiEntityActionDataType();
    
    void registerBlockActionFactory(String name, IActionData<Triple<Level, BlockPos, Direction>> action);
    
    SerializableDataType<?> getBlockActionDataType();
    
    void registerEntityActionFactory(String name, IActionData<Entity> action);
    
    SerializableDataType<?> getEntityActionDataType();
    
    void registerItemActionFactory(String name, IActionData<Tuple<Level, Mutable<ItemStack>>> action);
    
    SerializableDataType<?> getItemActionDataType();
    
}
