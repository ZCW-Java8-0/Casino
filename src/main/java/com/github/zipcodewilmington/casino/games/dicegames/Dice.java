package com.github.zipcodewilmington.casino.games.dicegames;

import java.util.Random;

public class Dice {
    private Random random = new Random();
    private Integer number;

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
        int results = 0;
        for (int i = 0; i < numOfDice; i++) {
            results += rollDice();
        }
        return results;
    }
}
