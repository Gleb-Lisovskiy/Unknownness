package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Event4TickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		boolean found = false;
		if (UnknownnessModVariables.event_4 > 0) {
			UnknownnessModVariables.event_4 = UnknownnessModVariables.event_4 - 1;
			UnknownnessModVariables.event = 3;
		}
		if (UnknownnessModVariables.event_4 == 1) {
			UnknownnessModVariables.all_shadow_despawn = true;
		}
	}
}
