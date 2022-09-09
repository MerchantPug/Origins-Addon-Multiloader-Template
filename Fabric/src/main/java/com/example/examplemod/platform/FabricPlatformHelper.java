package com.example.examplemod.platform;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.action.IActionFactory;
import com.example.examplemod.condition.IConditionFactory;
import com.example.examplemod.platform.services.IPlatformHelper;
import com.example.examplemod.power.factory.IPowerFactory;
import com.google.auto.service.AutoService;
import com.mojang.datafixers.util.Pair;
import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
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
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@AutoService(IPlatformHelper.class)
public class FabricPlatformHelper implements IPlatformHelper {
    
    @Override
    public String getPlatformName() {
        return "Fabric";
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
    
    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
    
    @Override
    public <P extends Power> PowerFactory<P> registerPowerFactory(String name, IPowerFactory<P> power) {
        ResourceLocation id = ExampleMod.asResource(name);
        return Registry.register(ApoliRegistries.POWER_FACTORY, id, power.createFabricFactory(id));
    }
    
    @Override
    public <P extends Power> List<P> getPowers(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory) {
        return PowerHolderComponent.getPowers(entity, powerClass);
    }
    
    @Override
    public <P extends Power> boolean hasPower(LivingEntity entity, Class<P> powerClass, PowerFactory<P> powerFactory) {
        return PowerHolderComponent.hasPower(entity, powerClass);
    }
    
    
    @Override
    public void registerBiEntityCondition(String name, IConditionFactory<Tuple<Entity, Entity>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIENTITY_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBiEntityCondition(Object condition, Entity actor, Entity target) {
        return ((Predicate<Tuple<Entity, Entity>>)condition).test(new Tuple<>(actor, target));
    }
    
    @Override
    public SerializableDataType<?> getBiEntityConditionDataType() {
        return ApoliDataTypes.BIENTITY_CONDITION;
    }

    @Override
    public Predicate<Tuple<Entity, Entity>> getPredicateFromBiEntityConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerBiomeCondition(String name, IConditionFactory<Holder<Biome>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIOME_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBiomeCondition(Object condition, Holder<Biome> biome) {
        return ((Predicate<Holder<Biome>>)condition).test(biome);
    }
    
    @Override
    public SerializableDataType<?> getBiomeConditionDataType() {
        return ApoliDataTypes.BIOME_CONDITION;
    }

    @Override
    public Predicate<Holder<Biome>> getPredicateFromBiomeConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerBlockCondition(String name, IConditionFactory<BlockInWorld> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BLOCK_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkBlockCondition(Object condition, Level level, BlockPos pos) {
        return ((Predicate<BlockInWorld>)condition).test(new BlockInWorld(level, pos, true));
    }
    
    @Override
    public SerializableDataType<?> getBlockConditionDataType() {
        return ApoliDataTypes.BLOCK_CONDITION;
    }

    @Override
    public Predicate<BlockInWorld> getPredicateFromBlockConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerDamageCondition(String name, IConditionFactory<Tuple<DamageSource, Float>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.DAMAGE_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkDamageCondition(Object condition, DamageSource source, float amount) {
        return ((Predicate<Tuple<DamageSource, Float>>)condition).test(new Tuple<>(source, amount));
    }
    
    @Override
    public SerializableDataType<?> getDamageConditionDataType() {
        return ApoliDataTypes.DAMAGE_CONDITION;
    }

    @Override
    public Predicate<Tuple<DamageSource, Float>> getPredicateFromDamageConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerEntityCondition(String name, IConditionFactory<Entity> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ENTITY_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkEntityCondition(Object condition, Entity entity) {
        return ((Predicate<Entity>)condition).test(entity);
    }
    
    @Override
    public SerializableDataType<?> getEntityConditionDataType() {
        return ApoliDataTypes.ENTITY_CONDITION;
    }

    @Override
    public Predicate<Entity> getPredicateFromEntityConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerFluidCondition(String name, IConditionFactory<FluidState> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.FLUID_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkFluidCondition(Object condition, FluidState fluidState) {
        return ((Predicate<FluidState>)condition).test(fluidState);
    }
    
    @Override
    public SerializableDataType<?> getFluidConditionDataType() {
        return ApoliDataTypes.FLUID_CONDITION;
    }

    @Override
    public Predicate<FluidState> getPredicateFromFluidConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerItemCondition(String name, IConditionFactory<ItemStack> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ITEM_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public boolean checkItemCondition(Object condition, ItemStack stack) {
        return ((Predicate<ItemStack>)condition).test(stack);
    }
    
    @Override
    public SerializableDataType<?> getItemConditionDataType() {
        return ApoliDataTypes.ITEM_CONDITION;
    }

    @Override
    public Predicate<ItemStack> getPredicateFromItemConditionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerBiEntityActionFactory(String name, IActionFactory<Tuple<Entity, Entity>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIENTITY_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeBiEntityAction(Object action, Entity actor, Entity target) {
        ((Consumer<Tuple<Entity, Entity>>)action).accept(new Tuple<>(actor, target));
    }
    
    @Override
    public SerializableDataType<?> getBiEntityActionDataType() {
        return ApoliDataTypes.BIENTITY_ACTION;
    }

    @Override
    public Consumer<Tuple<Entity, Entity>> getConsumerFromBiEntityActionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerBlockActionFactory(String name, IActionFactory<Triple<Level, BlockPos, Direction>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BLOCK_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeBlockAction(Object action, Level level, BlockPos pos, Direction direction) {
        ((Consumer<Triple<Level, BlockPos, Direction>>)action).accept(Triple.of(level, pos, direction));
    }
    
    @Override
    public SerializableDataType<?> getBlockActionDataType() {
        return ApoliDataTypes.BLOCK_ACTION;
    }

    @Override
    public Consumer<Triple<Level, BlockPos, Direction>> getConsumerFromBlockActionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerEntityActionFactory(String name, IActionFactory<Entity> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ENTITY_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public void executeEntityAction(Object action, Entity entity) {
        ((Consumer<Entity>)action).accept(entity);
    }
    
    @Override
    public SerializableDataType<?> getEntityActionDataType() {
        return ApoliDataTypes.ENTITY_ACTION;
    }

    @Override
    public Consumer<Entity> getConsumerFromEntityActionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }


    @Override
    public void registerItemActionFactory(String name, IActionFactory<Tuple<Level, Mutable<ItemStack>>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ITEM_ACTION, id, new ActionFactory<>(
            id, action.getSerializableData(),
            (data, pair) -> action.execute(data, new Tuple<>(pair.getA(), new MutableObject<>(pair.getB())))
        ));
    }
    
    @Override
    public void executeItemAction(Object action, Level level, Mutable<ItemStack> mutable) {
        ((Consumer<Tuple<Level, ItemStack>>)action).accept(new Tuple<>(level, mutable.getValue()));
    }
    
    @Override
    public SerializableDataType<?> getItemActionDataType() {
        return ApoliDataTypes.ITEM_ACTION;
    }

    @Override
    public Consumer<Mutable<ItemStack>> getConsumerFromItemActionDataInstance(SerializableData.Instance data, String fieldName) {
        return data.get(fieldName);
    }

}
