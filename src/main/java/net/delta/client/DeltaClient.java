package net.delta.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class DeltaClient implements ClientModInitializer {
    public static KeyBinding openGuiKeyBinding;

    @Override
    public void onInitializeClient() {
        openGuiKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "MainUi",
                GLFW.GLFW_KEY_GRAVE_ACCENT,
                "DeltaClient"
        ));

    }
}