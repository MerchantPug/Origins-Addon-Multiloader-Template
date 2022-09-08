package com.example.examplemod.platform.services;

import com.example.examplemod.action.IActionFactory;
import com.example.examplemod.condition.IConditionFactory;
import com.example.examplemod.power.factory.IPowerFactory;
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
    <P extends Power> PowerFactory<P> registerPowerFactory(String name, IPowerFactory<P> power);
    
    <P extends Power> List<P> getPowers(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory);
    
    <P extends Power> boolean hasPower(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory);
    
    
    void registerBiEntityCondition(String name, IConditionFactory<Tuple<Entity, Entity>> condition);
    
    boolean checkBiEntityCondition(Object condition, Entity actor, Entity target);
    
    SerializableDataType<?> getBiEntityConditionDataType();
    
    
    void registerBiomeCondition(String name, IConditionFactory<Holder<Biome>> condition);
    
    boolean checkBiomeCondition(Object condition, Holder<Biome> biome);
    
    SerializableDataType<?> getBiomeConditionDataType();
    
    
    void registerBlockCondition(String name, IConditionFactory<BlockInWorld> condition);
    
    boolean checkBlockCondition(Object condition, Level level, BlockPos pos);
    
    SerializableDataType<?> getBlockConditionDataType();
    
    
    void registerDamageCondition(String name, IConditionFactory<Tuple<DamageSource, Float>> condition);
    
    boolean checkDamageCondition(Object condition, DamageSource source, float amount);
    
    SerializableDataType<?> getDamageConditionDataType();
    
    
    void registerEntityCondition(String name, IConditionFactory<Entity> condition);
    
    boolean checkEntityCondition(Object condition, Entity entity);
    
    SerializableDataType<?> getEntityConditionDataType();
    
    
    void registerFluidCondition(String name, IConditionFactory<FluidState> condition);
    
    boolean checkFluidCondition(Object condition, FluidState fluidState);
    
    SerializableDataType<?> getFluidConditionDataType();
    
    
    void registerItemCondition(String name, IConditionFactory<ItemStack> condition);
    
    boolean checkItemCondition(Object condition, ItemStack stack);
    
    SerializableDataType<?> getItemConditionDataType();
    
    
    void registerBiEntityActionFactory(String name, IActionFactory<Tuple<Entity, Entity>> action);
    
    void executeBiEntityAction(Object action, Entity actor, Entity target);
    
    SerializableDataType<?> getBiEntityActionDataType();
    
    
    void registerBlockActionFactory(String name, IActionFactory<Triple<Level, BlockPos, Direction>> action);
    
    void executeBlockAction(Object action, Level level, BlockPos pos, Direction direction);
    
    SerializableDataType<?> getBlockActionDataType();
    
    
    void registerEntityActionFactory(String name, IActionFactory<Entity> action);
    
    void executeEntityAction(Object action, Entity entity);
    
    SerializableDataType<?> getEntityActionDataType();
    
    
    void registerItemActionFactory(String name, IActionFactory<Tuple<Level, Mutable<ItemStack>>> action);
    
    void executeItemAction(Object action, Level level, Mutable<ItemStack> mutable);
    
    SerializableDataType<?> getItemActionDataType();
    
}
