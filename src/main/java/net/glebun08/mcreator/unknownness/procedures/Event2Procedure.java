package net.glebun08.mcreator.unknownness.procedures;

import net.minecraft.world.scores.Team;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.glebun08.mcreator.unknownness.UnknownnessMod;

import java.util.ArrayList;

public class Event2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double z_ = 0;
		double y_ = 0;
		double x_ = 0;
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
				_level.getScoreboard().addPlayerTeam("0");
			if (world instanceof Level _level) {
				PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("0");
				if (_pt != null)
					_pt.setNameTagVisibility(Team.Visibility.NEVER);
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					Entity _entityTeam = entity;
					PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam("0");
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
					PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("0");
					if (_pt != null)
						_level.getScoreboard().removePlayerTeam(_pt);
				}
			});
		}
	}
}
