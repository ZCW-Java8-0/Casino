package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.abstractclasses.WagingPlayer;

public class CrapsPlayer extends WagingPlayer {

    @Override
    public CrapsGame play() {
        return null;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }
}
