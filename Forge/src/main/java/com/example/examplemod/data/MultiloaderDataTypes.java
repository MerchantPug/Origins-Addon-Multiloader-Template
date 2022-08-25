package com.example.examplemod.data;

import io.github.apace100.calio.data.SerializableDataType;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredItemCondition;

public class MultiloaderDataTypes {
    public static final SerializableDataType<ConfiguredItemCondition<?, ?>> ITEM_CONDITION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredItemCondition.class), ConfiguredItemCondition.CODEC);
    public static final SerializableDataType<ConfiguredEntityAction<?, ?>> ENTITY_ACTION = new SerializableDataType<>(MultiloaderDataTypes.castClass(ConfiguredEntityAction.class), ConfiguredEntityAction.CODEC);

    private static <T> Class<T> castClass(Class<?> aClass) {
        return (Class<T>)aClass;
    }
}
