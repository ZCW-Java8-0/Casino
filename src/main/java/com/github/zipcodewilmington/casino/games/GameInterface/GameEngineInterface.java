package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Iterator;

public interface GameEngineInterface <PlayerType extends Player, GameType> {
    void start();
    GameType getGame();
}
