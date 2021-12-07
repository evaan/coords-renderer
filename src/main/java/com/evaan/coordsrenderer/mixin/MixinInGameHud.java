package com.evaan.coordsrenderer.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
	@Inject(at = @At(value = "RETURN"), method = "render", cancellable = true)
	public void render(MatrixStack matrixStack, float float_1, CallbackInfo info) {
		if (MinecraftClient.getInstance().player != null) MinecraftClient.getInstance().textRenderer.drawWithShadow(matrixStack, "X: " + (int) MinecraftClient.getInstance().player.getX() + " Y: " + (int) MinecraftClient.getInstance().player.getY() + " Z: " + (int) MinecraftClient.getInstance().player.getZ(), 2, 2, 0xffffff);
	}
}
