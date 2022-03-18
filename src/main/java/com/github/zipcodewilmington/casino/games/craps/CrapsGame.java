package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.interfaces.GameInterface;

import java.util.List;

public class CrapsGame implements GameInterface<CrapsPlayer> {
    Boolean isDiceGame = true;

    @Override
    public Boolean isOver() {
        return null;
    }

    @Override
    public void addPlayer(CrapsPlayer player) {

    }

    @Override
    public void addPlayers(List<? extends CrapsPlayer> player) {

    }

    @Override
    public void evaluateTurn(CrapsPlayer player) {

    }

    @Override
    public void remove(CrapsPlayer player) {

    }

    @Override
    public void run() {

    }
}
