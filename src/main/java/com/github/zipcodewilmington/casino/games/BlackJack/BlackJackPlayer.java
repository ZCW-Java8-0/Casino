package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

public class BlackJackPlayer extends Player implements Gambler {

    public BlackJackPlayer(Person person) {
        super(person);
    }

    @Override
    public void addWinning(int winning) {
    }

    @Override
    public int getBalance() {
        return this.getPerson().getWallet();
    }

    @Override
    public void applyBet(int bet) {
        this.getPerson().setWallet(this.getBalance()-bet);
    }
}
