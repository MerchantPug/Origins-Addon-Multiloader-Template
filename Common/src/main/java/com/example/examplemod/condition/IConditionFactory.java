package com.example.examplemod.condition;

import io.github.apace100.calio.data.SerializableData;

public interface IConditionFactory<T> {
    
    default SerializableData getSerializableData() {
        return new SerializableData();
    }
    
    boolean check(SerializableData.Instance data, T instance);
    
}