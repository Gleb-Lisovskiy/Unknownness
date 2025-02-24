package net.glebun08.mcreator.unknownness.network;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnknownnessModVariables {
	public static String FirstPlayer = "\"\"";
	public static double event = 0;
	public static double Players = 0;
	public static double event_4 = 0;
	public static double event_cd = 0.0;
	public static boolean events_toggle = true;
	public static boolean all_shadow_despawn = false;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}
