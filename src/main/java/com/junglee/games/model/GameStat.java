package com.junglee.games.model;

/**
 *
 */
public class GameStat {

  private final String gameName;

  private int totalKills;

  private final long durationPlayed;
  private final int spellCast;
  private final int firstKills;
  private final long totalSpellDamage;
  private final long totalDamageDone;
  private final int totalAssists;
  private final int attemptedAttacks;
  private final int totalHits;
  private final boolean isWon;
  public GameStat(final String gameName, final int totalKills, final long durationPlayed,
      final int spellCast, final int firstKills, final long totalSpellDamage,
      final long totalDamageDone, final int totalAssists, final int attemptedAttacks,
      final int totalHits, final boolean isWon) {
    this.gameName = gameName;
    this.totalKills = totalKills;
    this.durationPlayed = durationPlayed;
    this.spellCast = spellCast;
    this.firstKills = firstKills;
    this.totalSpellDamage = totalSpellDamage;
    this.totalDamageDone = totalDamageDone;
    this.totalAssists = totalAssists;
    this.attemptedAttacks = attemptedAttacks;
    this.totalHits = totalHits;
    this.isWon = isWon;
  }

  public static GameStatBuilder builder() {
    return new GameStatBuilder();
  }

  public String getGameName() {
    return this.gameName;
  }

  public int getTotalKills() {
    return this.totalKills;
  }

  public long getDurationPlayed() {
    return this.durationPlayed;
  }

  public int getSpellCast() {
    return this.spellCast;
  }

  public int getFirstKills() {
    return this.firstKills;
  }

  public void setTotalKills(final int totalKills) {
    this.totalKills = totalKills;
  }

  public long getTotalSpellDamage() {
    return this.totalSpellDamage;
  }

  public long getTotalDamageDone() {
    return this.totalDamageDone;
  }

  public int getTotalAssists() {
    return this.totalAssists;
  }

  public int getAttemptedAttacks() {
    return this.attemptedAttacks;
  }

  public int getTotalHits() {
    return this.totalHits;
  }

  public boolean isWon() {
    return this.isWon;
  }

  public static class GameStatBuilder {

    private String gameName;
    private int totalKills;
    private long durationPlayed;
    private int spellCast;
    private int firstKills;
    private long totalSpellDamage;
    private long totalDamageDone;
    private int totalAssists;
    private int attemptedAttacks;
    private int totalHits;
    private boolean isWon;

    GameStatBuilder() {
    }

    public GameStat.GameStatBuilder gameName(final String gameName) {
      this.gameName = gameName;
      return this;
    }

    public GameStat.GameStatBuilder totalKills(final int totalKills) {
      this.totalKills = totalKills;
      return this;
    }

    public GameStat.GameStatBuilder durationPlayed(final long durationPlayed) {
      this.durationPlayed = durationPlayed;
      return this;
    }

    public GameStat.GameStatBuilder spellCast(final int spellCast) {
      this.spellCast = spellCast;
      return this;
    }

    public GameStat.GameStatBuilder firstKills(final int firstKills) {
      this.firstKills = firstKills;
      return this;
    }

    public GameStat.GameStatBuilder totalSpellDamage(final long totalSpellDamage) {
      this.totalSpellDamage = totalSpellDamage;
      return this;
    }

    public GameStat.GameStatBuilder totalDamageDone(final long totalDamageDone) {
      this.totalDamageDone = totalDamageDone;
      return this;
    }

    public GameStat.GameStatBuilder totalAssists(final int totalAssists) {
      this.totalAssists = totalAssists;
      return this;
    }

    public GameStat.GameStatBuilder attemptedAttacks(final int attemptedAttacks) {
      this.attemptedAttacks = attemptedAttacks;
      return this;
    }

    public GameStat.GameStatBuilder totalHits(final int totalHits) {
      this.totalHits = totalHits;
      return this;
    }

    public GameStat.GameStatBuilder isWon(final boolean isWon) {
      this.isWon = isWon;
      return this;
    }

    public GameStat build() {
      return new GameStat(gameName, totalKills, durationPlayed, spellCast, firstKills,
          totalSpellDamage, totalDamageDone, totalAssists, attemptedAttacks, totalHits, isWon);
    }

    public String toString() {
      return "GameStat.GameStatBuilder(gameName=" + this.gameName + ", totalKills="
          + this.totalKills
          + ", durationPlayed=" + this.durationPlayed + ", spellCast=" + this.spellCast
          + ", firstKills=" + this.firstKills + ", totalSpellDamage=" + this.totalSpellDamage
          + ", totalDamageDone=" + this.totalDamageDone + ", totalAssists=" + this.totalAssists
          + ", attemptedAttacks=" + this.attemptedAttacks + ", totalHits=" + this.totalHits
          + ", isWon=" + this.isWon + ")";
    }
  }
}
