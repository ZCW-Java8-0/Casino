package com.github.zipcodewilmington.casino.games.ceelo;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

public class CeeLoPlayer extends Player implements Gambler {

    public CeeLoPlayer(Person person) {
        super(person);
    }

    @Override
    public void addWinning(int winning) {

    }

    @Override
    public void applyBet(int bet) {

    }

    @Override
    public int getBalance() {
        return 0;
    }
}
