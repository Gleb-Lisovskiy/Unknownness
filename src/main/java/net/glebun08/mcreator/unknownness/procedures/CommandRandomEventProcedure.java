package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

public class CommandRandomEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		UnknownnessModVariables.MapVariables.get(world).event = Mth.nextInt(RandomSource.create(), 1, 12);
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
		EventExecuteProcedure.execute(world, x, y, z, entity);
	}
}
