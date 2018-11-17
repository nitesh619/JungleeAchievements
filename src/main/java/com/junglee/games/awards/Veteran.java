package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * “Veteran” Award – a user receives this for playing more than 1000 games in their lifetime.
 *
 * @author nitesh.jain
 */
public class Veteran implements IAward {

  private static final int VETERAN_GAMES = 1000;

  public boolean isEligible(final Player player, final GameStat model) {
    return player.getGamesPlayed() >= VETERAN_GAMES;
  }

  @Override
  public String toString() {
    return "Veteran";
  }

}
