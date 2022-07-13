package com.github.zipcodewilmington.casino.games.dicegames;

import java.util.Random;

public class Dice {
    Random random = new Random();
    Integer number;

    public Dice() {
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer rollDice() {
        number = random.nextInt(6) + 1;
        return number;
    }
    public int tossAndSum(int numOfDice) {
        int results = 0;
        for (int i = 0; i < numOfDice; i++) {
            results += rollDice();
        }
        return results;
    }
}
