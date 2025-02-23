
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.glebun08.mcreator.unknownness.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.glebun08.mcreator.unknownness.client.renderer.ShadowRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnknownnessModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(UnknownnessModEntities.SHADOW.get(), ShadowRenderer::new);
	}
}
