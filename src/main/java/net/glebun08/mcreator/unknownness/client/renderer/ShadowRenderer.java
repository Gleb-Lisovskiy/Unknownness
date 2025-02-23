
package net.glebun08.mcreator.unknownness.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.glebun08.mcreator.unknownness.entity.ShadowEntity;

public class ShadowRenderer extends HumanoidMobRenderer<ShadowEntity, HumanoidModel<ShadowEntity>> {
	public ShadowRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<ShadowEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(ShadowEntity entity) {
		return new ResourceLocation("unknownness:textures/entities/black.png");
	}

	@Override
	protected boolean isShaking(ShadowEntity entity) {
		return true;
	}
}
