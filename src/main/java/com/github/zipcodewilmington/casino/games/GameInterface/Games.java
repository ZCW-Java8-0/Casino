package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public interface Games {
    void play();
    void setPlayerMax();
    void addPlayer(Player player);
    void removePlayer(Player player);
    Map<Player, Boolean> winCondition();
    Player[] getWinner();
    void exit();
}
