package com.example.examplemod.platform;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.action.IActionData;
import com.example.examplemod.condition.IConditionData;
import com.example.examplemod.platform.services.IPlatformHelper;
import com.example.examplemod.power.data.IPowerData;
import com.google.auto.service.AutoService;
import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableDataType;
import net.fabricmc.loader.api.FabricLoader;
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

import java.util.List;

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
    public <P extends Power> PowerFactory<P> registerPowerFactory(String name, IPowerData<P> power) {
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
    public void registerBiEntityCondition(String name, IConditionData<Tuple<Entity, Entity>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIENTITY_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getBiEntityConditionDataType() {
        return ApoliDataTypes.BIENTITY_CONDITION;
    }
    
    @Override
    public void registerBiomeCondition(String name, IConditionData<Holder<Biome>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIOME_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getBiomeConditionDataType() {
        return ApoliDataTypes.BIOME_CONDITION;
    }
    
    @Override
    public void registerBlockCondition(String name, IConditionData<BlockInWorld> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BLOCK_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getBlockConditionDataType() {
        return ApoliDataTypes.BLOCK_CONDITION;
    }
    
    @Override
    public void registerDamageCondition(String name, IConditionData<Tuple<DamageSource, Float>> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.DAMAGE_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getDamageConditionDataType() {
        return ApoliDataTypes.DAMAGE_CONDITION;
    }
    
    @Override
    public void registerEntityCondition(String name, IConditionData<Entity> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ENTITY_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getEntityConditionDataType() {
        return ApoliDataTypes.ENTITY_CONDITION;
    }
    
    @Override
    public void registerFluidCondition(String name, IConditionData<FluidState> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.FLUID_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getFluidConditionDataType() {
        return ApoliDataTypes.FLUID_CONDITION;
    }
    
    @Override
    public void registerItemCondition(String name, IConditionData<ItemStack> condition) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ITEM_CONDITION, id, new ConditionFactory<>(id, condition.getSerializableData(), condition::check));
    }
    
    @Override
    public SerializableDataType<?> getItemConditionDataType() {
        return ApoliDataTypes.ITEM_CONDITION;
    }

    @Override
    public void registerBiEntityActionFactory(String name, IActionData<Tuple<Entity, Entity>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BIENTITY_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public SerializableDataType<?> getBiEntityActionDataType() {
        return ApoliDataTypes.BIENTITY_ACTION;
    }
    
    @Override
    public void registerBlockActionFactory(String name, IActionData<Triple<Level, BlockPos, Direction>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.BLOCK_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public SerializableDataType<?> getBlockActionDataType() {
        return ApoliDataTypes.BLOCK_ACTION;
    }
    
    @Override
    public void registerEntityActionFactory(String name, IActionData<Entity> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ENTITY_ACTION, id, new ActionFactory<>(id, action.getSerializableData(), action::execute));
    }
    
    @Override
    public SerializableDataType<?> getEntityActionDataType() {
        return ApoliDataTypes.ENTITY_ACTION;
    }
    
    @Override
    public void registerItemActionFactory(String name, IActionData<Tuple<Level, Mutable<ItemStack>>> action) {
        ResourceLocation id = ExampleMod.asResource(name);
        Registry.register(ApoliRegistries.ITEM_ACTION, id, new ActionFactory<>(
            id, action.getSerializableData(),
            (data, pair) -> action.execute(data, new Tuple<>(pair.getA(), new MutableObject<>(pair.getB())))
        ));
    }
    
    @Override
    public SerializableDataType<?> getItemActionDataType() {
        return ApoliDataTypes.ITEM_ACTION;
    }
    
}
