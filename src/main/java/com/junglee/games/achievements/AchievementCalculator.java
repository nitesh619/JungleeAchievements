package com.junglee.games.achievements;

import static java.util.stream.Collectors.toList;

import com.junglee.games.awards.IAward;
import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;
import java.util.List;

public class AchievementCalculator implements IAchievementCalculator {

  private final List<IAward> availableAwards;

  public AchievementCalculator(final List<IAward> availableAwards) {
    this.availableAwards = availableAwards;
  }

  /**
   * @param player - Data for player with game history
   * @param stats - stats for the current game
   *
   * @return - list of awards earned in current game
   */
  public List<String> calculateAward(final Player player, final GameStat stats) {
    return availableAwards.stream()
        .filter(award -> award.isEligible(player, stats))
        .map(Object::toString)
        .collect(toList());
  }
}
