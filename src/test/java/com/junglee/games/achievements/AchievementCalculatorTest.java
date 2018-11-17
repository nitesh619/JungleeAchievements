package com.junglee.games.achievements;

import static com.junglee.games.EntryPoint.getAwardList;

import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AchievementCalculatorTest {

  private AchievementCalculator achievementCalculator;
  private Player player;
  private GameStat stat;

  @Before
  public void setUp() {
    achievementCalculator = new AchievementCalculator(getAwardList());
    player = preparePlayer();
    stat = prepareStats();
  }

  @Test
  public void testAllAchievements() {
    List<String> awards = achievementCalculator.calculateAward(player, stat);

    assert awards.size() == 5;
    assert awards.contains("Legend");
    assert awards.contains("Sharp Shooter");
    assert awards.contains("Big Winner");
    assert awards.containsAll(Arrays.asList("Bruiser", "Veteran"));
  }

  @Test
  public void testNotASharpShooter() {
    stat.setTotalKills(5);
    List<String> awards = achievementCalculator.calculateAward(player, stat);
    assert !awards.contains("Sharp Shooter");
  }

  @Test
  public void testNotALegend() {
    player.setTotalWins(33);
    List<String> awards = achievementCalculator.calculateAward(player, stat);
    assert !awards.contains("Legend");
  }

  @Test
  public void testNotAVeteran() {
    player.setGamesPlayed(999);
    List<String> awards = achievementCalculator.calculateAward(player, stat);
    assert !awards.contains("Veteran");
  }


  private GameStat prepareStats() {
    return GameStat.builder()
        .totalDamageDone(300)
        .totalSpellDamage(400)
        .attemptedAttacks(100)
        .totalKills(75)
        .build();
  }

  private Player preparePlayer() {
    return Player.builder()
        .gamesPlayed(1001)
        .totalWins(833)
        .build();
  }
}
