package com.example.examplemod.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "isVisuallySwimming", at = @At("RETURN"))
    private void examplemod$forceCrawl(CallbackInfoReturnable<Boolean> cir) {
        if ((Object)this instanceof LivingEntity) {
            cir.setReturnValue(true);
        }
    }
}
