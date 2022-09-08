package com.example.examplemod.platform;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.access.ItemStackLevelAccess;
import com.example.examplemod.action.*;
import com.example.examplemod.condition.*;
import com.example.examplemod.data.ApoliForgeDataTypes;
import com.example.examplemod.platform.services.IPlatformHelper;
import com.example.examplemod.power.factory.IPowerFactory;
import com.example.examplemod.registry.ExampleModRegisters;
import com.google.auto.service.AutoService;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.github.edwinmindcraft.apoli.api.power.configuration.*;
import io.github.edwinmindcraft.apoli.fabric.FabricPowerConfiguration;
import net.minecraft.MethodsReturnNonnullByDefault;
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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@SuppressWarnings("unchecked")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@AutoService(IPlatformHelper.class)
public class ForgePlatformHelper implements IPlatformHelper {
    
    @Override
    public String getPlatformName() {
        return "Forge";
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
    
    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
    
    @Override
    public <P extends Power> PowerFactory<P> registerPowerFactory(String name, IPowerFactory<P> power) {
        PowerFactory<P> powerFactory = new PowerFactory<>(ExampleMod.asResource(name), power.getSerializableData(), power.getPowerConstructorForge());
        ExampleModRegisters.POWERS.register(name, powerFactory::getWrapped);
        return powerFactory;
    }
    
    @Override
    public <P extends Power> List<P> getPowers(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory) {
        return IPowerContainer.getPowers(entity, powerFactory.getWrapped()).stream().map(configuredPowerHolder -> ((FabricPowerConfiguration<P>)configuredPowerHolder.get().getConfiguration()).power().apply((PowerType<P>) configuredPowerHolder.get().getPowerType(), entity)).toList();
    }
    
    @Override
    public <P extends Power> boolean hasPower(LivingEntity living, Class<P> powerClass, PowerFactory<P> powerFactory) {
        return IPowerContainer.hasPower(living, powerFactory.getWrapped());
    }
    
    
    @Override
    public void registerBiEntityCondition(String name, IConditionFactory<Tuple<Entity, Entity>> condition) {
        ExampleModRegisters.BIENTITY_CONDITIONS.register(name, () -> new FabricBiEntityCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBiEntityCondition(Object condition, Entity actor, Entity target) {
        return ((ConfiguredBiEntityCondition<?, ?>)condition).check(actor, target);
    }
    
    @Override
    public SerializableDataType<?> getBiEntityConditionDataType() {
        return ApoliForgeDataTypes.BIENTITY_CONDITION.get();
    }
    
    
    @Override
    public void registerBiomeCondition(String name, IConditionFactory<Holder<Biome>> condition) {
        ExampleModRegisters.BIOME_CONDITIONS.register(name, () -> new FabricBiomeCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBiomeCondition(Object condition, Holder<Biome> biome) {
        return ((ConfiguredBiomeCondition<?, ?>)condition).check(biome);
    }
    
    @Override
    public SerializableDataType<?> getBiomeConditionDataType() {
        return ApoliForgeDataTypes.BIOME_CONDITION.get();
    }
    
    
    @Override
    public void registerBlockCondition(String name, IConditionFactory<BlockInWorld> condition) {
        ExampleModRegisters.BLOCK_CONDITIONS.register(name, () -> new FabricBlockCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBlockCondition(Object condition, Level level, BlockPos pos) {
        return ((ConfiguredBlockCondition<?, ?>)condition).check(level, pos, () -> level.getBlockState(pos));
    }
    
    @Override
    public SerializableDataType<?> getBlockConditionDataType() {
        return ApoliForgeDataTypes.BLOCK_CONDITION.get();
    }
    
    
    @Override
    public void registerDamageCondition(String name, IConditionFactory<Tuple<DamageSource, Float>> condition) {
        ExampleModRegisters.DAMAGE_CONDITIONS.register(name, () -> new FabricDamageCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkDamageCondition(Object condition, DamageSource source, float amount) {
        return ((ConfiguredDamageCondition<?, ?>)condition).check(source, amount);
    }
    
    @Override
    public SerializableDataType<?> getDamageConditionDataType() {
        return ApoliForgeDataTypes.DAMAGE_CONDITION.get();
    }
    
    
    @Override
    public void registerEntityCondition(String name, IConditionFactory<Entity> condition) {
        ExampleModRegisters.ENTITY_CONDITIONS.register(name, () -> new FabricEntityCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkEntityCondition(Object condition, Entity entity) {
        return ((ConfiguredEntityCondition<?, ?>)condition).check(entity);
    }
    
    @Override
    public SerializableDataType<?> getEntityConditionDataType() {
        return ApoliForgeDataTypes.ENTITY_CONDITION.get();
    }
    
    
    @Override
    public void registerFluidCondition(String name, IConditionFactory<FluidState> condition) {
        ExampleModRegisters.FLUID_CONDITIONS.register(name, () -> new FabricFluidCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkFluidCondition(Object condition, FluidState fluidState) {
        return ((ConfiguredFluidCondition<?, ?>)condition).check(fluidState);
    }
    
    @Override
    public SerializableDataType<?> getFluidConditionDataType() {
        return ApoliForgeDataTypes.FLUID_CONDITION.get();
    }
    
    
    @Override
    public void registerItemCondition(String name, IConditionFactory<ItemStack> condition) {
        ExampleModRegisters.ITEM_CONDITIONS.register(name, () -> new FabricItemCondition(condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkItemCondition(Object condition, ItemStack stack) {
        return ((ConfiguredItemCondition<?, ?>)condition).check(((ItemStackLevelAccess)(Object)stack).getLevel(), stack);
    }
    
    @Override
    public SerializableDataType<?> getItemConditionDataType() {
        return ApoliForgeDataTypes.ITEM_CONDITION.get();
    }
    
    
    @Override
    public void registerBiEntityActionFactory(String name, IActionFactory<Tuple<Entity, Entity>> action) {
        ExampleModRegisters.BIENTITY_ACTIONS.register(name, () -> new FabricBiEntityAction(action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeBiEntityAction(Object action, Entity actor, Entity target) {
        ((ConfiguredBiEntityAction<?, ?>)action).execute(actor, target);
    }
    
    @Override
    public SerializableDataType<?> getBiEntityActionDataType() {
        return ApoliForgeDataTypes.BIENTITY_ACTION.get();
    }
    
    
    @Override
    public void registerBlockActionFactory(String name, IActionFactory<Triple<Level, BlockPos, Direction>> action) {
        ExampleModRegisters.BLOCK_ACTIONS.register(name, () -> new FabricBlockAction(action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeBlockAction(Object action, Level level, BlockPos pos, Direction direction) {
        ((ConfiguredBlockAction<?, ?>)action).execute(level, pos, direction);
    }
    
    @Override
    public SerializableDataType<?> getBlockActionDataType() {
        return ApoliForgeDataTypes.BLOCK_ACTION.get();
    }
    
    
    @Override
    public void registerEntityActionFactory(String name, IActionFactory<Entity> action) {
        ExampleModRegisters.ENTITY_ACTIONS.register(name, () -> new FabricEntityAction(action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeEntityAction(Object action, Entity entity) {
        ((ConfiguredEntityAction<?, ?>)action).execute(entity);
    }
    
    @Override
    public SerializableDataType<?> getEntityActionDataType() {
        return ApoliForgeDataTypes.ENTITY_ACTION.get();
    }
    
    
    @Override
    public void registerItemActionFactory(String name, IActionFactory<Tuple<Level, Mutable<ItemStack>>> action) {
        ExampleModRegisters.ITEM_ACTIONS.register(name, () -> new FabricItemAction(action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeItemAction(Object action, Level level, Mutable<ItemStack> mutable) {
        ((ConfiguredItemAction<?, ?>)action).execute(level, mutable);
    }
    
    @Override
    public SerializableDataType<?> getItemActionDataType() {
        return ApoliForgeDataTypes.ITEM_ACTION.get();
    }
    
}
