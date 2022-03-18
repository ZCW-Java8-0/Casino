package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

public class RoulettePlayer extends Player implements Gambler {
    public RoulettePlayer ( Person person ) {
        super(person);
    }

    @Override
    public void addWinning ( int winning ) {

    }

    @Override
    public void applyBet(int bet)
    {
        this.getPerson().setWallet(this.getBalance()-bet);
    }


    @Override
    public int getBalance() {
        return this.getPerson().getWallet();
    }
}
