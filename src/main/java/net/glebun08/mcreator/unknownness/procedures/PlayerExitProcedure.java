package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerExitProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (UnknownnessModVariables.MapVariables.get(world).Players == 0) {
			UnknownnessModVariables.MapVariables.get(world).FirstPlayer = "";
			UnknownnessModVariables.MapVariables.get(world).syncData(world);
		}
		UnknownnessModVariables.MapVariables.get(world).Players = UnknownnessModVariables.MapVariables.get(world).Players - 1;
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
	}
}
