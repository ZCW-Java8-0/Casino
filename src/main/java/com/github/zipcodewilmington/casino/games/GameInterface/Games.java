package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public interface Games<PlayerType extends Player> {
    void play();
    void setPlayerMax();
    void addPlayer(PlayerType player);
    void removePlayer(PlayerType player);
    Map<PlayerType, Boolean> setWinCondition();
    Player[] getWinner();
    void exit();
}
