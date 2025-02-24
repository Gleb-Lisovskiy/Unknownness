package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.commands.CommandSourceStack;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandEventExecuteProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		UnknownnessModVariables.event = DoubleArgumentType.getDouble(arguments, "int");
	}
}
