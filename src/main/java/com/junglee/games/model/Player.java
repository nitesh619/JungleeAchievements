package com.junglee.games.model;

import com.junglee.games.awards.IAward;
import java.util.Map;

public class Player {

  private final String name;
  private int gamesPlayed;

  private long gamesDuration;
  private int totalKills;
  private int totalWins;

  private int totalSpells;

  private Map<IAward, Integer> badgeOfHonors;

  public Player(final String name) {
    this.name = name;
  }

  public Player(final PlayerBuilder playerBuilder) {
    this.name = playerBuilder.name;
    this.gamesPlayed = playerBuilder.gamesPlayed;
    this.gamesDuration = playerBuilder.gamesDuration;
    this.totalKills = playerBuilder.totalKills;
    this.totalWins = playerBuilder.totalWins;
    this.totalSpells = playerBuilder.totalSpells;
    this.badgeOfHonors = playerBuilder.badgeOfHonors;
  }

  public static PlayerBuilder builder() {
    return new PlayerBuilder();
  }

  public int getTotalLosses() {
    return gamesPlayed - totalWins;
  }

  public int getGamesPlayed() {
    return gamesPlayed;
  }

  public void setTotalWins(final int totalWins) {
    this.totalWins = totalWins;
  }

  public int getTotalWins() {
    return totalWins;
  }

  public void setGamesPlayed(final int gamesPlayed) {
    this.gamesPlayed = gamesPlayed;
  }

  public String toString() {
    return name;
  }

  public String getName() {
    return this.name;
  }

  public long getGamesDuration() {
    return this.gamesDuration;
  }

  public int getTotalKills() {
    return this.totalKills;
  }

  public int getTotalSpells() {
    return this.totalSpells;
  }

  public Map<IAward, Integer> getBadgeOfHonors() {
    return this.badgeOfHonors;
  }

  public void setBadgeOfHonors(
      final Map<IAward, Integer> badgeOfHonors) {
    this.badgeOfHonors = badgeOfHonors;
  }

  public static class PlayerBuilder {

    private String name;
    private int gamesPlayed;
    private long gamesDuration;
    private int totalKills;
    private int totalWins;
    private int totalSpells;
    private Map<IAward, Integer> badgeOfHonors;

    PlayerBuilder() {
    }

    public PlayerBuilder name(final String name) {
      this.name = name;
      return this;
    }

    public PlayerBuilder gamesPlayed(final int gamesPlayed) {
      this.gamesPlayed = gamesPlayed;
      return this;
    }

    public PlayerBuilder gamesDuration(final long gamesDuration) {
      this.gamesDuration = gamesDuration;
      return this;
    }

    public PlayerBuilder totalKills(final int totalKills) {
      this.totalKills = totalKills;
      return this;
    }

    public PlayerBuilder totalWins(final int totalWins) {
      this.totalWins = totalWins;
      return this;
    }

    public PlayerBuilder totalSpells(final int totalSpells) {
      this.totalSpells = totalSpells;
      return this;
    }

    public PlayerBuilder badgeOfHonors(final Map<IAward, Integer> badgeOfHonors) {
      this.badgeOfHonors = badgeOfHonors;
      return this;
    }

    public Player build() {
      return new Player(this);
    }

    public String toString() {
      return "Player.PlayerBuilder(name=" + this.name + ", gamesPlayed=" + this.gamesPlayed
          + ", gamesDuration=" + this.gamesDuration + ", totalKills=" + this.totalKills
          + ", totalWins=" + this.totalWins + ", totalSpells=" + this.totalSpells
          + ", badgeOfHonors="
          + this.badgeOfHonors + ")";
    }
  }
}
