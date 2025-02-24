package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		UnknownnessModVariables.Players = UnknownnessModVariables.Players + 1;
	}
}
