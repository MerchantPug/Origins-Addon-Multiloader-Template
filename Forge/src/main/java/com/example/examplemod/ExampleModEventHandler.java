package com.example.examplemod;

import com.example.examplemod.capability.IItemStackLevelProviderCapability;
import com.example.examplemod.capability.ItemStackLevelProviderCapability;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID)
public class ExampleModEventHandler {
    @SubscribeEvent
    public static void registerItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        event.addCapability(IItemStackLevelProviderCapability.ID, new ItemStackLevelProviderCapability());
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            event.getEntity().getItemBySlot(slot).getCapability(ItemStackLevelProviderCapability.INSTANCE).ifPresent(cap -> {
                if (cap.getLevel() == null) {
                    cap.setLevel(event.getEntity().level);
                }
            });
        }
        if (event.getEntity() instanceof Player player) {
            for (int i = 0; i < player.getInventory().items.size(); ++i) {
                player.getInventory().items.get(i).getCapability(ItemStackLevelProviderCapability.INSTANCE).ifPresent(cap -> {
                    if (cap.getLevel() == null) {
                        cap.setLevel(player.level);
                    }
                });
            }
        }
    }
}
