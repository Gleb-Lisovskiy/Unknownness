package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class SystemEventsProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject sub1 = new com.google.gson.JsonObject();
		if (UnknownnessModVariables.events_toggle == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/unknownness"), File.separator + "common-config.json");
			if (UnknownnessModVariables.event_cd > 0) {
				UnknownnessModVariables.event_cd = UnknownnessModVariables.event_cd - 1;
			}
			if (file.exists()) {
				if (UnknownnessModVariables.event_cd <= 0) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							sub1 = main.get("events").getAsJsonObject();
							UnknownnessModVariables.event_cd = sub1.get("rate").getAsDouble();
							if (Math.random() == 0.8) {
								UnknownnessModVariables.event = Mth.nextInt(RandomSource.create(), 1, 12);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
