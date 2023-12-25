package net.delta.mixins;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Timer;
import java.util.TimerTask;

@Mixin(TitleScreen.class)
public class WindowTitle extends Screen {



    @Unique
    private static final String CUSTOM_WINDOW_TITLE = "DeltaClient ∆     |    デルタクライアント    |  Version: a0.0.1"; //Alpha = a | Beta = b | Release = r
    @Unique
    private Timer timer;

    protected WindowTitle() {
        super(Text.literal(""));
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void setupTimer(CallbackInfo info) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setCustomWindowTitle();
            }
        }, 0, 500);
    }

    @Unique
    private void setCustomWindowTitle() {
        assert this.client != null;
        this.client.getWindow().setTitle(CUSTOM_WINDOW_TITLE);
    }
}

