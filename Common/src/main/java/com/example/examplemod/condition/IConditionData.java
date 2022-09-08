package com.example.examplemod.condition;

import io.github.apace100.calio.data.SerializableData;

public interface IConditionData<T> {
    
    default SerializableData getSerializableData() {
        return new SerializableData();
    }
    
    boolean check(SerializableData.Instance data, T instance);
    
}
