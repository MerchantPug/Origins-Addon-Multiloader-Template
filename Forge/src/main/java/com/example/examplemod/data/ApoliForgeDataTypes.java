package com.example.examplemod.data;

import io.github.apace100.calio.data.SerializableDataType;
import io.github.edwinmindcraft.apoli.api.power.configuration.*;
import net.minecraft.core.Holder;
import net.minecraftforge.common.util.Lazy;

public class ApoliForgeDataTypes {

    public static final Lazy<SerializableDataType<Holder<ConfiguredPower<?, ?>>>> POWER_TYPE = Lazy.of(() -> new SerializableDataType<>(castClass(Holder.class), ConfiguredPower.CODEC_SET.holderRef()));

    public static final Lazy<SerializableDataType<ConfiguredBiEntityCondition<?, ?>>> BIENTITY_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredBiEntityCondition.class), ConfiguredBiEntityCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredBiomeCondition<?, ?>>> BIOME_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredBiomeCondition.class), ConfiguredBiomeCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredBlockCondition<?, ?>>> BLOCK_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredBlockCondition.class), ConfiguredBlockCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredDamageCondition<?, ?>>> DAMAGE_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredDamageCondition.class), ConfiguredDamageCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredEntityCondition<?, ?>>> ENTITY_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredEntityCondition.class), ConfiguredEntityCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredFluidCondition<?, ?>>> FLUID_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredFluidCondition.class), ConfiguredFluidCondition.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredItemCondition<?, ?>>> ITEM_CONDITION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredItemCondition.class), ConfiguredItemCondition.CODEC));

    public static final Lazy<SerializableDataType<ConfiguredBiEntityAction<?, ?>>> BIENTITY_ACTION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredBiEntityAction.class), ConfiguredBiEntityAction.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredBlockAction<?, ?>>> BLOCK_ACTION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredBlockAction.class), ConfiguredBlockAction.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredEntityAction<?, ?>>> ENTITY_ACTION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredEntityAction.class), ConfiguredEntityAction.CODEC));
    public static final Lazy<SerializableDataType<ConfiguredItemAction<?, ?>>> ITEM_ACTION = Lazy.of(() -> new SerializableDataType<>(ApoliForgeDataTypes.castClass(ConfiguredItemAction.class), ConfiguredItemAction.CODEC));
    
    @SuppressWarnings("unchecked")
    private static <T> Class<T> castClass(Class<?> cls) {
        return (Class<T>)cls;
    }
    
}