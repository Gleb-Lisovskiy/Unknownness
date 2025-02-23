
package net.glebun08.mcreator.unknownness.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.glebun08.mcreator.unknownness.entity.Shadow1Entity;

public class Shadow1Renderer extends HumanoidMobRenderer<Shadow1Entity, HumanoidModel<Shadow1Entity>> {
	public Shadow1Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Shadow1Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Shadow1Entity entity) {
		return new ResourceLocation("unknownness:textures/entities/black.png");
	}

	@Override
	protected boolean isShaking(Shadow1Entity entity) {
		return true;
	}
}
