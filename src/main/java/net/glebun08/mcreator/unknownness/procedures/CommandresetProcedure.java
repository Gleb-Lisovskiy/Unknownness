package net.glebun08.mcreator.unknownness.procedures;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

public class CommandresetProcedure {
	public static void execute() {
		UnknownnessModVariables.event_4 = 0;
		UnknownnessModVariables.event_cd = 0;
		UnknownnessModVariables.event = 0;
		UnknownnessModVariables.all_shadow_despawn = false;
		UnknownnessModVariables.events_toggle = true;
	}
}
