package net.delta.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class IpMessage {

    @Inject(method = "onGameJoin", at = @At("RETURN"))
    private void onGameJoin(GameJoinS2CPacket packet, CallbackInfo info) {
        String serverIP = ((ClientPlayNetworkHandler) (Object) this).getConnection().getAddress().toString();


        MutableText prefix = Text.literal("DeltaClient ∆ | ").formatted(Formatting.LIGHT_PURPLE);


        MutableText suffix = Text.literal(" IP: " + serverIP).formatted(Formatting.GRAY);




        Text message = prefix.append(suffix.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
                .withFormatting(Formatting.WHITE)));




        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(message);
    }
}
