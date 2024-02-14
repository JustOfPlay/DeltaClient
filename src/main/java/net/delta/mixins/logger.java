package net.delta.mixins;

import net.minecraft.client.MinecraftClient;


import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class logger {
    @Inject(at = @At("RETURN"), method = "damage")
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable info) {
        PlayerEntity self = (PlayerEntity) (Object) this;

        System.out.println("LOG: DeltaClient ∆ | " + self.getGameProfile().getName() + " received damage");

        MutableText prefix = Text.literal("DeltaClient ∆ | ").formatted(Formatting.LIGHT_PURPLE);
        MutableText suffix = Text.literal("Ouch. That hurts!!!").formatted(Formatting.GRAY);

        Text message = prefix.append(suffix.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withFormatting(Formatting.WHITE)));

        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(message);
    }

}


