package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.List;
import java.util.Comparator;

public class ShadowTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double y_player = 0;
		if (entity.getPersistentData().getDouble("todespawn") > 1) {
			entity.getPersistentData().putDouble("todespawn", (entity.getPersistentData().getDouble("todespawn") - 1));
		}
		if (entity.getPersistentData().getDouble("todespawn") == 1) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (Math.random() == 0.7 && entity.getPersistentData().getBoolean("readytohit") == false) {
			entity.getPersistentData().putBoolean("readytohit", true);
		}
		if (Math.random() == 0.5) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity.onGround()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 10, false, false));
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					y_player = entityiterator.getY() + 1.5;
					if (entityiterator.getPose() == Pose.SWIMMING || entityiterator instanceof LivingEntity _livEnt15 && _livEnt15.isSleeping()) {
						y_player = entityiterator.getY();
					}
					if (entityiterator.isShiftKeyDown()) {
						y_player = entityiterator.getY() + 1.2;
					}
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), y_player, (entityiterator.getZ())));
				}
			}
		}
		if (entity instanceof Mob _entity)
			_entity.setPersistenceRequired();
	}
}
