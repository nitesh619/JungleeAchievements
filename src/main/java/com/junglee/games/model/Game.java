package com.junglee.games.model;

import static com.junglee.games.constants.JungleeConstants.MAX_ASSISTS;
import static com.junglee.games.constants.JungleeConstants.MAX_ATTEMPTED_ATTACKS;
import static com.junglee.games.constants.JungleeConstants.MAX_DAMAGE_DONE;
import static com.junglee.games.constants.JungleeConstants.MAX_DURATION;
import static com.junglee.games.constants.JungleeConstants.MAX_FIRST_KILLS;
import static com.junglee.games.constants.JungleeConstants.MAX_HITS;
import static com.junglee.games.constants.JungleeConstants.MAX_KILLS;
import static com.junglee.games.constants.JungleeConstants.MAX_SPELLS;
import static com.junglee.games.constants.JungleeConstants.MAX_SPELL_DAMAGE;
import static com.junglee.games.constants.JungleeConstants.MAX_TEAM_SIZE;
import static com.junglee.games.constants.JungleeConstants.MIN_TEAM_SIZE;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import com.junglee.games.exceptions.IllegalTeamSizeException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class Game {

  public static final Random rand = new Random();
  private final String gameName;
  private final List<Player> teamA;
  private final List<Player> teamB;

  private Map<Player, GameStat> playerGameStats;

  public Game(final String gameName, final List<Player> teamA,
      final List<Player> teamB) {
    this.gameName = gameName;

    validateTeamSize(teamA, teamB);

    this.teamA = teamA;
    this.teamB = teamB;
  }

  private void validateTeamSize(final List<Player> teamA, final List<Player> teamB) {
    if (teamA.size() != teamB.size() || isInvalidSize(teamA.size()) || isInvalidSize(
        teamB.size())) {
      throw new IllegalTeamSizeException();
    }
  }

  public void playGame() {
    System.out.println("Let's Play " + gameName);
    playerGameStats = Stream.of(teamA, teamB)
        .flatMap(Collection::stream)
        .collect(toMap(identity(), player -> simulateGameStats()));
    System.out.println("Ka-BOOM!!");
  }

  public Map<Player, GameStat> finishGame() {
    //perform post game reset and operation
    System.out.println("Game Over!");
    return playerGameStats; //return game stats
  }

  private GameStat simulateGameStats() {
    int kills = rand.nextInt(MAX_KILLS);
    return GameStat.builder()
        .gameName(gameName)
        .totalKills(kills)
        .attemptedAttacks(kills + rand.nextInt(MAX_ATTEMPTED_ATTACKS))
        .totalDamageDone(rand.nextInt(MAX_DAMAGE_DONE))
        .totalAssists(rand.nextInt(MAX_ASSISTS))
        .durationPlayed(rand.nextInt(MAX_DURATION))
        .firstKills(rand.nextInt(MAX_FIRST_KILLS))
        .spellCast(rand.nextInt(MAX_SPELLS))
        .totalHits(rand.nextInt(MAX_HITS))
        .totalSpellDamage(rand.nextInt(MAX_SPELL_DAMAGE))
        .isWon(rand.nextBoolean())
        .build();
  }

  private boolean isInvalidSize(final int size) {
    return size < MIN_TEAM_SIZE || size > MAX_TEAM_SIZE;
  }
}
