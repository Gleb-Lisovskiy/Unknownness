package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (UnknownnessModVariables.Players == 1 && !(entity.getDisplayName().getString()).equals(UnknownnessModVariables.FirstPlayer)) {
			UnknownnessModVariables.FirstPlayer = entity.getDisplayName().getString();
		}
		if ((entity.getDisplayName().getString()).equals(UnknownnessModVariables.FirstPlayer)) {
			if (UnknownnessModVariables.event > 0) {
				EventExecuteProcedure.execute();
			}
		}
	}
}
