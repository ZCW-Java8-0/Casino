package com.github.zipcodewilmington.casino;

import java.util.Map;

public interface Games {
    void play();
    void setPlayerMax();
    Map<Player, Boolean> winCondition();
    Player[] getWinner();
    void exit();
}
