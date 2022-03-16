package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.GameInterface.Games;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public class BlackJack implements GamblingGame<BlackJackPlayer> {
    private Map<BlackJackPlayer, Integer> bets;
    private int maxPartySize;
    @Override
    public void play() {
    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 4;
    }

    @Override
    public void addPlayer(BlackJackPlayer player) {
        this.bets.put(player,0);
    }

    @Override
    public void removePlayer(BlackJackPlayer player) {
        this.bets.remove(player);
    }


    @Override
    public void setWinCondition() {

    }

    @Override
    public Player[] getWinner() {
        return new Player[0];
    }

    @Override
    public void exit() {
    }

    @Override
    public void setBets() {

    }

    @Override
    public void distributeWinningsToWinners() {

    }
}
