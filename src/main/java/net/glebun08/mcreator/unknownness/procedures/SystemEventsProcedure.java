package net.glebun08.mcreator.unknownness.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
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
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		File file = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject sub1 = new com.google.gson.JsonObject();
		if (UnknownnessModVariables.MapVariables.get(world).events_toggle == true) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/unknownness"), File.separator + "server-config.json");
			if (UnknownnessModVariables.MapVariables.get(world).event_cd > 0) {
				UnknownnessModVariables.MapVariables.get(world).event_cd = UnknownnessModVariables.MapVariables.get(world).event_cd - 1;
				UnknownnessModVariables.MapVariables.get(world).syncData(world);
			}
			if (file.exists()) {
				if (UnknownnessModVariables.MapVariables.get(world).event_cd <= 0) {
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
							UnknownnessModVariables.MapVariables.get(world).event_cd = sub1.get("rate").getAsDouble();
							UnknownnessModVariables.MapVariables.get(world).syncData(world);
							if (Math.random() == 0.8) {
								UnknownnessModVariables.MapVariables.get(world).event = Mth.nextInt(RandomSource.create(), 1, 12);
								UnknownnessModVariables.MapVariables.get(world).syncData(world);
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
