package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ConnectFourPlayer implements PlayerInterface {
    int positionPlacement;

    public int getPositionPlacement() {
        return positionPlacement;
    }
    public void setPositionPlacement(int chosenPosition) {
        this.positionPlacement = chosenPosition;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return null;
    }
}
