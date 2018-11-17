package com.junglee.games.achievements;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;
import java.util.List;

public interface IAchievementCalculator {

  List<String> calculateAward(Player player, GameStat model);

}
