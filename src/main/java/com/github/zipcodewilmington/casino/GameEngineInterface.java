package com.github.zipcodewilmington.casino;

public interface GameEngineInterface {
    void start();
    Game getGame();
    Iterable<Player> getPlayers();
}
