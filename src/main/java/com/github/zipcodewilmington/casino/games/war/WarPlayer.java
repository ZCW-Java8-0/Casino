package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.abstractclasses.Player;

public class WarPlayer extends Player {


    @Override
    public WarGame play() {
        return null;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }
}
