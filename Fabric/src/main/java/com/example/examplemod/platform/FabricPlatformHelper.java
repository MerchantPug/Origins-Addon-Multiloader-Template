package com.example.examplemod.platform;


import com.example.examplemod.platform.services.IPlatformHelper;
import com.google.auto.service.AutoService;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import io.github.apace100.apoli.util.modifier.Modifier;
import io.github.apace100.apoli.util.modifier.ModifierUtil;
import io.github.apace100.calio.data.SerializableDataType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

@SuppressWarnings("unchecked")
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
    public SerializableDataType<?> getModifierDataType() {
        return Modifier.DATA_TYPE;
    }

    @Override
    public SerializableDataType<?> getModifiersDataType() {
        return Modifier.LIST_TYPE;
    }

    @Override
    public double applyModifiers(LivingEntity entity, List<?> modifiers, double value) {
        return ModifierUtil.applyModifiers(entity, (List<Modifier>) modifiers, value);
    }

    @Override
    public double getReachDistance(Entity entity) {
        double base = (entity instanceof Player player && player.getAbilities().instabuild) ? 5 : 4.5;
        return (entity instanceof LivingEntity living && isModLoaded("reach-entity-attributes")) ?
                ReachEntityAttributes.getReachDistance(living, base) : base;
    }

    @Override
    public double getAttackRange(Entity entity) {
        double base = (entity instanceof Player player && player.getAbilities().instabuild) ? 6 : 3;
        return (entity instanceof LivingEntity living && isModLoaded("reach-entity-attributes")) ?
                ReachEntityAttributes.getAttackRange(living, base) : base;
    }

}