package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

public class EventExecuteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double y_ = 0;
		double x_ = 0;
		double z_ = 0;
		boolean found = false;
		if (UnknownnessModVariables.MapVariables.get(world).event == 1) {
			Event1Procedure.execute(world, x, y, z);
		}
		if (UnknownnessModVariables.MapVariables.get(world).event == 2) {
			Event2Procedure.execute(world, entity);
		}
		if (UnknownnessModVariables.MapVariables.get(world).event == 3) {
			Event3Procedure.execute(world, x, y, z);
		}
		UnknownnessModVariables.MapVariables.get(world).event = 0;
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
	}
}
