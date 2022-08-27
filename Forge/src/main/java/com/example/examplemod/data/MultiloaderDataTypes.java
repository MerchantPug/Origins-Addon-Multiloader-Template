package com.example.examplemod.data;

import io.github.apace100.calio.data.SerializableDataType;
import io.github.edwinmindcraft.apoli.api.power.configuration.*;

public class MultiloaderDataTypes {
    public static final SerializableDataType<ConfiguredBiEntityCondition<?, ?>> BIENTITY_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredBiEntityCondition.class), ConfiguredBiEntityCondition.CODEC);
    public static final SerializableDataType<ConfiguredBiEntityCondition<?, ?>> BIOME_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredBiEntityCondition.class), ConfiguredBiEntityCondition.CODEC);
    public static final SerializableDataType<ConfiguredBiEntityCondition<?, ?>> BLOCK_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredBiEntityCondition.class), ConfiguredBiEntityCondition.CODEC);
    public static final SerializableDataType<ConfiguredDamageCondition<?, ?>> DAMAGE_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredDamageCondition.class), ConfiguredDamageCondition.CODEC);
    public static final SerializableDataType<ConfiguredEntityCondition<?, ?>> ENTITY_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredEntityCondition.class), ConfiguredEntityCondition.CODEC);
    public static final SerializableDataType<ConfiguredFluidCondition<?, ?>> FLUID_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredFluidCondition.class), ConfiguredFluidCondition.CODEC);
    public static final SerializableDataType<ConfiguredItemCondition<?, ?>> ITEM_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredItemCondition.class), ConfiguredItemCondition.CODEC);

    public static final SerializableDataType<ConfiguredBiEntityAction<?, ?>> BIENTITY_ACTION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredBiEntityAction.class), ConfiguredBiEntityAction.CODEC);
    public static final SerializableDataType<ConfiguredBlockAction<?, ?>> BLOCK_ACTION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredBlockAction.class), ConfiguredBlockAction.CODEC);
    public static final SerializableDataType<ConfiguredEntityAction<?, ?>> ENTITY_ACTION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredEntityAction.class), ConfiguredEntityAction.CODEC);
    public static final SerializableDataType<ConfiguredItemAction<?, ?>> ITEM_ACTION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredItemAction.class), ConfiguredItemAction.CODEC);

    private static <T> Class<T> castClass(Class<?> aClass) {
        return (Class<T>)aClass;
    }
}
