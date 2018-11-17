package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * Every Award aka achievement should implement this interface.
 *
 * @author nitesh.jain
 */

public interface IAward {

  /**
   * @param player - Data for player with game history
   * @param stats - stats for the current game
   *
   * @return - true if player is eligible for the award
   */
  boolean isEligible(Player player, GameStat stats);

}
