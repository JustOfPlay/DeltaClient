package net.delta;
import net.fabricmc.api.ModInitializer;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;
public class Delta implements ModInitializer {

    @Override
    public void onInitialize() {
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");

        // Mixin-Klassen registrieren
        Mixins.addConfiguration("delta.mixins.json");
    }
}
