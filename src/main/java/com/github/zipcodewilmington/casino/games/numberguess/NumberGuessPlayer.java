package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.abstractclasses.WagingPlayer;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends WagingPlayer {

    @Override
    public NumberGuessGame play() {
        return null;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }
}