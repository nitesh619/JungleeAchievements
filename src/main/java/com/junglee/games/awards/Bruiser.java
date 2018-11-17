package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * “Bruiser” Award – a user receives this for doing more than 500 points of damage in one game
 *
 * @author nitesh.jain
 */
public class Bruiser implements IAward {

  private static final int BRUISER_DAMAGE = 500;

  public boolean isEligible(final Player player, final GameStat model) {
    long totalDamage = model.getTotalDamageDone()
        + model.getTotalSpellDamage();
    return totalDamage >= BRUISER_DAMAGE;
  }

  @Override
  public String toString() {
    return "Bruiser";
  }
}
