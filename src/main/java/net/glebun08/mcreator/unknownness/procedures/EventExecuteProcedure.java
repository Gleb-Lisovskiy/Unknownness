package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.scores.Team;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.glebun08.mcreator.unknownness.network.UnknownnessModVariables;
import net.glebun08.mcreator.unknownness.init.UnknownnessModEntities;
import net.glebun08.mcreator.unknownness.UnknownnessMod;

import java.util.ArrayList;

public class EventExecuteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double y_ = 0;
		double x_ = 0;
		double z_ = 0;
		boolean found = false;
		if (UnknownnessModVariables.MapVariables.get(world).event == 1) {
			y_ = y - 10;
			x_ = x + Mth.nextDouble(RandomSource.create(), -70, 70);
			z_ = z + Mth.nextDouble(RandomSource.create(), -70, 70);
			for (int index0 = 0; index0 < 20; index0++) {
				y_ = y_ + 1;
				if (!((world.getBlockState(BlockPos.containing(x_, y_ - 1, z_))).getBlock() == Blocks.AIR) && (world.getBlockState(BlockPos.containing(x_, y_, z_))).getBlock() == Blocks.AIR) {
					found = true;
					break;
				}
			}
			if (found == true) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.LIGHTNING_BOLT.spawn(_level, BlockPos.containing(x_, y_, z_), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		if (UnknownnessModVariables.MapVariables.get(world).event == 2) {
			if (world instanceof Level _level && _level.getScoreboard()
					.getPlayerTeam((entity instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()) != null
							? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
							: "")) != null
									? _level.getScoreboard()
											.getPlayerTeam((entity instanceof LivingEntity _teamEnt && _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()) != null
													? _teamEnt.level().getScoreboard().getPlayersTeam(_teamEnt instanceof Player _pl ? _pl.getGameProfile().getName() : _teamEnt.getStringUUID()).getName()
													: ""))
											.getNameTagVisibility() == Team.Visibility.ALWAYS
									: false) {
				if (world instanceof Level _level)
					_level.getScoreboard().addPlayerTeam("null");
				if (world instanceof Level _level) {
					PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("null");
					if (_pt != null)
						_pt.setNameTagVisibility(Team.Visibility.NEVER);
				}
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					{
						Entity _entityTeam = entity;
						PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam("null");
						if (_pt != null) {
							if (_entityTeam instanceof Player _player)
								_entityTeam.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
							else
								_entityTeam.level().getScoreboard().addPlayerToTeam(_entityTeam.getStringUUID(), _pt);
						}
					}
				}
				UnknownnessMod.queueServerWork(Mth.nextInt(RandomSource.create(), 300, 800), () -> {
					if (world instanceof Level _level) {
						PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("null");
						if (_pt != null)
							_level.getScoreboard().removePlayerTeam(_pt);
					}
				});
			}
		}
		if (UnknownnessModVariables.MapVariables.get(world).event == 12) {
			y_ = y - 10;
			x_ = x + Mth.nextDouble(RandomSource.create(), -70, 70);
			z_ = z + Mth.nextDouble(RandomSource.create(), -70, 70);
			for (int index1 = 0; index1 < 20; index1++) {
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
		UnknownnessModVariables.MapVariables.get(world).event = 0;
		UnknownnessModVariables.MapVariables.get(world).syncData(world);
	}
}
