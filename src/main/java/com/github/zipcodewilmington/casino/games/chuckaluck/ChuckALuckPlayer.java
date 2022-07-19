package com.github.zipcodewilmington.casino.games.chuckaluck;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Player;

public class ChuckALuckPlayer extends Player implements PlayerInterface {

    Player player;
    CasinoAccount casinoAccount;

    public ChuckALuckPlayer(){
    }

    public Player getPlayer(){
        return this.player;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return casinoAccount;
    }
}
