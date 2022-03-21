package com.github.zipcodewilmington.casino.games.TicTacToe;

import com.github.zipcodewilmington.casino.games.Person.Gambler;
import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;

public class TicTacToePlayer extends Player implements Gambler {
    public TicTacToePlayer(Person person){super(person);}

    @Override
    public void addWinning(int winning) {
        this.getPerson().setWallet(this.getBalance() + winning);
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
