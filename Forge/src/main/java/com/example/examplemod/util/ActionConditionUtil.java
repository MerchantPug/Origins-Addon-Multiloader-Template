package com.example.examplemod.util;

import com.example.examplemod.access.ItemStackLevelAccess;
import com.mojang.datafixers.util.Pair;
import io.github.edwinmindcraft.apoli.api.power.configuration.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.material.FluidState;
import org.apache.commons.lang3.mutable.MutableObject;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.logging.log4j.core.net.TcpSocketManager;

import javax.annotation.Nullable;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ActionConditionUtil {
    @Nullable public static Predicate<Pair<Entity, Entity>> biEntityConditionPredicate(Holder<ConfiguredBiEntityCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return (pair) -> condition.get().check(pair.getFirst(), pair.getSecond());
    }

    @Nullable public static Predicate<Holder<Biome>> biomeConditionPredicate(Holder<ConfiguredBiomeCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return condition.get()::check;
    }

    @Nullable public static Consumer<BlockInWorld> blockCondition(Holder<ConfiguredBlockCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return (block) -> condition.get().check(block.getLevel(), block.getPos(), block::getState);
    }

    @Nullable public static Predicate<Pair<DamageSource, Float>> damageConditionPredicate(Holder<ConfiguredDamageCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return (pair) -> condition.get().check(pair.getFirst(), pair.getSecond());
    }

    @Nullable public static Predicate<Entity> entityConditionPredicate(Holder<ConfiguredEntityCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return condition.get()::check;
    }

    @Nullable public static Predicate<FluidState> fluidConditionPredicate(Holder<ConfiguredFluidCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return condition.get()::check;
    }

    @Nullable public static Predicate<ItemStack> itemConditionPredicate(Holder<ConfiguredItemCondition<?, ?>> condition) {
        if (condition == null) {
            return null;
        }
        return (itemStack) -> {
            if (((ItemStackLevelAccess)(Object)itemStack).yourmodid$getLevel() == null) {
                return false;
            }
            return condition.get().check(((ItemStackLevelAccess)(Object)itemStack).yourmodid$getLevel(), itemStack);
        };
    }

    @Nullable public static Consumer<Pair<Entity, Entity>> biEntityActionConsumer(Holder<ConfiguredBiEntityAction<?, ?>> action) {
        if (action == null) {
            return null;
        }
        return (pair) -> action.get().execute(pair.getFirst(), pair.getSecond());
    }

    @Nullable public static Consumer<Triple<Level, BlockPos, Direction>> blockActionConsumer(Holder<ConfiguredBlockAction<?, ?>> action) {
        if (action == null) {
            return null;
        }
        return (triple) -> action.get().execute(triple.getLeft(), triple.getMiddle(), triple.getRight());
    }

    @Nullable public static Consumer<Entity> entityActionConsumer(Holder<ConfiguredEntityAction<?, ?>> action) {
        if (action == null) {
            return null;
        }
        return action.get()::execute;
    }

    @Nullable public static Consumer<ItemStack> itemActionConsumer(Holder<ConfiguredItemAction<?, ?>> action) {
        if (action == null) {
            return null;
        }
        return (stack) -> action.get().execute(((ItemStackLevelAccess)(Object)stack).yourmodid$getLevel(), new MutableObject<>(stack));
    }
}
