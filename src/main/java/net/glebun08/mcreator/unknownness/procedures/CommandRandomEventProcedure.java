package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

public class CommandRandomEventProcedure {
	public static void execute() {
		UnknownnessModVariables.event = Mth.nextInt(RandomSource.create(), 1, 12);
		EventExecuteProcedure.execute();
	}
}
