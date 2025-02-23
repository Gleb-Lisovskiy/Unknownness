package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

public class CommandRandomEventProcedure {
	public static void execute(LevelAccessor world) {
		UnknownnessModVariables.MapVariables.get(world).event_cd = 1;
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
	}
}
