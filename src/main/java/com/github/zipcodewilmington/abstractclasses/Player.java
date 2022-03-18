package com.github.zipcodewilmington.abstractclasses;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.interfaces.PlayerInterface;

public abstract class Player implements PlayerInterface {
    public CasinoAccount casinoAccount;
    int accountBalance = casinoAccount.getAccountBalance();
    Boolean isTurn;

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
