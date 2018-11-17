package com.junglee.games;

import static com.junglee.games.model.Game.rand;
import static java.lang.String.join;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.junglee.games.achievements.AchievementCalculator;
import com.junglee.games.achievements.IAchievementCalculator;
import com.junglee.games.awards.BigWinner;
import com.junglee.games.awards.Bruiser;
import com.junglee.games.awards.IAward;
import com.junglee.games.awards.SharpShooter;
import com.junglee.games.awards.Veteran;
import com.junglee.games.model.Game;
import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Create a driver class that sets up sample data and calls the achievements system, printing out
 * achievements to the console.
 *
 * @author nitesh.jain
 */
public class EntryPoint {

  public static void main(String[] args) {

    List<Player> teamRaw = createTeam("Ambrose", "Brock", "Ronda", "Kurt");
    List<Player> teamSmackDown = createTeam("Becky", "AJ Styles", "Randy", "Jeff");

    Game game = new Game("The Clash of Titans", teamRaw, teamSmackDown);

    game.playGame();

    IAchievementCalculator achievementCalculator = new AchievementCalculator(getAwardList());
    Map<Player, GameStat> playerGameStats = game.finishGame();

    //calculate achievements for each player in team's
    Map<Player, List<String>> playerAchievements = playerGameStats.entrySet().stream()
        .collect(toMap(Entry::getKey, playerGameModel -> achievementCalculator
            .calculateAward(playerGameModel.getKey(), playerGameModel.getValue())));

    showAchievements(playerAchievements);
  }

  // Add more achievement's here to extend
  private static List<IAward> getAwardList() {
    return Arrays.asList(
        new SharpShooter(),
        new Bruiser(),
        new Veteran(),
        new BigWinner());
  }

  private static List<Player> createTeam(final String... teamMembers) {
    return Arrays.stream(teamMembers)
        .map(EntryPoint::createPlayer)
        .collect(toList());
  }

  private static Player createPlayer(final String name) {
    return Player.builder()
        .name(name)
        .gamesDuration(rand.nextInt(99999999))
        .gamesPlayed(rand.nextInt(1600))
        .totalKills(rand.nextInt(9999999))
        .totalSpells(rand.nextInt(9999))
        .totalWins(rand.nextInt(1600))
        .badgeOfHonors(getBadges())
        .build();
  }

  private static Map<IAward, Integer> getBadges() {
    List<IAward> awardList = getAwardList();
    HashMap<IAward, Integer> awardMap = new HashMap<>();
    for (IAward anAwardList : awardList) {
      awardMap.put(anAwardList, rand.nextInt(10));
    }
    return awardMap;
  }

  private static void showAchievements(final Map<Player, List<String>> playerAchievements) {
    String leftAlignFormat = "| %-10s | %-49s |%n";
    System.out.format("+------------+---------------------------------------------------+%n");
    System.out.format("| Player     | Achievement's                                     |%n");
    System.out.format("+------------+---------------------------------------------------+%n");
    playerAchievements.forEach((player, awards) ->
        System.out.format(leftAlignFormat, player, join(", ", awards)));
    System.out.format("+------------+---------------------------------------------------+%n");
  }
}
