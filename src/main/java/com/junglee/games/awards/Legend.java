package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * “Legend Award” – a user receives this if he wins more than 80 percent of his total games played.
 *
 * @author nitesh.jain
 */
public class Legend implements IAward {

  private static final float LEGEND_PERCENTAGE = 80;

  @Override
  public boolean isEligible(final Player player, final GameStat stats) {
    if (player.getGamesPlayed() > 0) {
      float hitPercentage = (float) player.getTotalWins() / player.getGamesPlayed() * 100;
      return hitPercentage >= LEGEND_PERCENTAGE;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Legend";
  }
}
