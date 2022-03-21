package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.games.GameInterface.GameEngineInterface;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.ArrayList;
import java.util.List;

abstract class GameEngine <PlayerType extends Player, GameType>
        implements GameEngineInterface<PlayerType, GameType> {
    private GameType game;
    private List<PlayerType> players= new ArrayList<>();
    public GameEngine(GameType game, PlayerType player){
        this.game = game;
        this.players.add(player);
    }

    public List<PlayerType> getPlayers() {
        return players;
    }

    public GameType getGame() {
        return this.game;
    }
}
