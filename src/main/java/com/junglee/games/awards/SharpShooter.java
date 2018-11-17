package com.junglee.games.awards;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;

/**
 * “Sharpshooter Award” – a user receives this for landing 75% of their attacks, assuming they have
 * at least attacked once.
 *
 * @author nitesh.jain
 */
public class SharpShooter implements IAward {

  private static final int SHARP_SHOOTER_PERCENTAGE = 75;

  public boolean isEligible(Player player, GameStat model) {
    if (model.getAttemptedAttacks() > 0) {
      float hitPercentage = (float) model.getTotalKills() / model.getAttemptedAttacks() * 100;
      return hitPercentage >= SHARP_SHOOTER_PERCENTAGE;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Sharp Shooter";
  }
}
