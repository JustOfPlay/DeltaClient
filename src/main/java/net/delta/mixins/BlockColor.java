package net.delta.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRenderManager.class)
public class BlockColor {

    @Inject(method = "renderBlock", at = @At("HEAD"), cancellable = true)
    private void renderBlockColor(BlockState state, BlockPos pos, BlockRenderView world, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, CallbackInfo ci) {
        // Hier wird die Farbe des Blocks geändert, dies ist jedoch ein Platzhalter und erfordert spezifische Logik
        // Ändere die Farbe entsprechend deiner Anforderungen
        matrices.push();
        matrices.translate(0.5D, 0.5D, 0.5D); // Zentriere den Block
        // Füge hier deine eigene Logik ein, um die Farbe zu ändern
        matrices.pop();

        // Storniere das eigentliche Rendering, da dies nur ein Platzhalter ist und die spezifische Logik fehlt
        ci.cancel();
    }
}
