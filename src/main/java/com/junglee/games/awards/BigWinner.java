package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * “Big Winner” Award – a user receives this for having 200 wins
 *
 * @author nitesh.jain
 */
public class BigWinner implements IAward {

  private static final int BIG_WINNER_WINS = 200;

  public boolean isEligible(final Player player, final GameStat model) {
    return player.getTotalWins() >= BIG_WINNER_WINS;
  }

  @Override
  public String toString() {
    return "Big Winner";
  }

}
