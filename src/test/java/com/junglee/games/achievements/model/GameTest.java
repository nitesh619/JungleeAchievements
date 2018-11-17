package com.junglee.games.achievements.model;

import static com.junglee.games.EntryPoint.createTeam;

import com.junglee.games.exceptions.IllegalTeamSizeException;
import com.junglee.games.model.Game;
import com.junglee.games.model.GameStat;
import com.junglee.games.model.Player;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GameTest {

  @Test
  public void testValidGame() {
    List<Player> teamA = createTeam("A1", "A2", "A3");
    List<Player> teamB = createTeam("B1", "B2", "B3");
    Game game = new Game("Test Game!", teamA, teamB);

    game.playGame();
    Map<Player, GameStat> playerGameStatMap = game.finishGame();

    assert playerGameStatMap.size() == teamA.size() + teamB.size();
  }

  @Test(expected = IllegalTeamSizeException.class)
  public void testInvalidTeamSize() {
    List<Player> teamA = createTeam("A1", "A2");
    List<Player> teamB = createTeam("B1", "B2", "B3");
    Game game = new Game("Test Game!", teamA, teamB);
    game.playGame();
  }
}
