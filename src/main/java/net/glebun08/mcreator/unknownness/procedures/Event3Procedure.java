package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.glebun08.mcreator.unknownness.init.UnknownnessModEntities;

public class Event3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double z_ = 0;
		double y_ = 0;
		double x_ = 0;
		if (Math.random() == 0.7) {
			y_ = y - 10;
			x_ = x + Mth.nextDouble(RandomSource.create(), -70, 70);
			z_ = z + Mth.nextDouble(RandomSource.create(), -70, 70);
			for (int index0 = 0; index0 < 40; index0++) {
				y_ = y_ + 1;
				if (!((world.getBlockState(BlockPos.containing(x_, y_ - 1, z_))).getBlock() == Blocks.AIR) && (world.getBlockState(BlockPos.containing(x_, y_, z_))).getBlock() == Blocks.AIR) {
					found = true;
					break;
				}
			}
			if (found == true) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = UnknownnessModEntities.SHADOW.get().spawn(_level, BlockPos.containing(x_, y_, z_), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}
