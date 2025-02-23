package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandEventExecuteProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		UnknownnessModVariables.MapVariables.get(world).event = DoubleArgumentType.getDouble(arguments, "int");
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
	}
}
