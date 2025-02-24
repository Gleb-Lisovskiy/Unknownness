package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.commands.CommandSourceStack;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class CommandToggleEventsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if (BoolArgumentType.getBool(arguments, "boolean") == true) {
			UnknownnessModVariables.events_toggle = true;
		} else {
			UnknownnessModVariables.events_toggle = false;
		}
	}
}
