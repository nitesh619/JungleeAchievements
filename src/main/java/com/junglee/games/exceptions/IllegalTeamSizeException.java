package com.junglee.games.exceptions;

import static com.junglee.games.constants.JungleeConstants.MAX_TEAM_SIZE;
import static com.junglee.games.constants.JungleeConstants.MIN_TEAM_SIZE;

public class IllegalTeamSizeException extends RuntimeException {

  @Override
  public String getMessage() {
    return "Not a valid team size, please specify between "
        + MIN_TEAM_SIZE + "-" + MAX_TEAM_SIZE
        + ", Also both team's should have equal number of players.";
  }
}
