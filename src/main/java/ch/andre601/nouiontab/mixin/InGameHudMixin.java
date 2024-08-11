package ch.andre601.nouiontab.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.gui.hud.in_game.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin{

	@Shadow
	@Final
	private PlayerListHud playerListHud;

	@Inject(
		method = {
			"renderOverlay",
			"renderCrosshair",
			"renderHotbar",
			"renderExperienceLevel",
			"renderStatusEffectOverlay",

			"renderDemoTimer",
			"renderScoreboard",
			"renderOverlayMessage",
			"renderTitles",
			"renderChat"
		},
		at = @At("HEAD"),
		cancellable = true
	)
	private void hideHudOnPlayerListRender(CallbackInfo ci){
		if(((PlayerListHudAccessor) this.playerListHud).nouiontab$isVisible()) {
			ci.cancel();
		}
	}
}
