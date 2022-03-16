package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.games.GameInterface.GameEngineInterface;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.List;

abstract class GameEngine <PlayerType extends Player, GameType>
        implements GameEngineInterface<PlayerType, GameType> {
    private GameType game;
    private List<PlayerType> players;
    public GameEngine(GameType game, List<PlayerType> players){
        this.game = game;
        this.players = players;
    }

    public List<PlayerType> getPlayers() {
        return players;
    }
}
