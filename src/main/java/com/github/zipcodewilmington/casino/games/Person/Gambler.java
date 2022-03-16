package com.github.zipcodewilmington.casino.games.Person;

public interface Gambler {
    void addWinning(int winning);
    void applyBet(int bet);
    int getBalance();
}
