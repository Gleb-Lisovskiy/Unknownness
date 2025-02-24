package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandEventRateProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		File file = new File("");
		com.google.gson.JsonObject sub1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/unknownness"), File.separator + "common-config.json");
		if (!file.exists()) {
			SetupconfigProcedure.execute();
		}
		sub1.addProperty("rate", Math.round(DoubleArgumentType.getDouble(arguments, "tick")));
		main.add("events", sub1);
		{
			com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(mainGSONBuilderVariable.toJson(main));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
