package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerExitProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (UnknownnessModVariables.Players == 0) {
			UnknownnessModVariables.FirstPlayer = "";
		}
		UnknownnessModVariables.Players = UnknownnessModVariables.Players - 1;
	}
}
