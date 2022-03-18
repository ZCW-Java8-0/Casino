package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.abstractclasses.WagingPlayer;

public class BlackJackPlayer extends WagingPlayer {

    @Override
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
