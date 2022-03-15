package com.github.zipcodewilmington.casino;

import java.util.ArrayList;

public interface GameEngineInterface {
    void start();
    Game getGame();
    ArrayList<Player> getPlayers();
}
