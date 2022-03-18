package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.abstractclasses.WagingPlayer;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends WagingPlayer {
    @Override
    public SlotsGame play() {
        return null;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }
}