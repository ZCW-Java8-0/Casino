package com.github.zipcodewilmington.casino.games.dicegames;

import java.util.Random;

public class Dice {
    private Random random = new Random();
    private Integer number;
    private Integer results;

    public Dice() {

    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer rollDice() {
        this.number = random.nextInt(6) + 1;
        return this.number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public int tossAndSum(int numOfDice) {
        this.results = 0;
        for (int i = 0; i < numOfDice; i++) {
            this.results += rollDice();
        }
        return this.results;
    }

    public Integer getResults() {
        return results;
    }
}
