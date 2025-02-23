package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class CommandToggleEventsProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (BoolArgumentType.getBool(arguments, "boolean") == true) {
			UnknownnessModVariables.MapVariables.get(world).events_toggle = true;
			UnknownnessModVariables.MapVariables.get(world).syncData(world);
		} else {
			UnknownnessModVariables.MapVariables.get(world).events_toggle = false;
			UnknownnessModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
