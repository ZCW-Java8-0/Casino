package com.github.zipcodewilmington.casino.games.highlowdice;

public class Dice {

    public void Dice(){

    }

    public int rollDice() {
        int roll = (int) (Math.random() * 6 + 1);
        return roll;
    }
    public int tossAndSum(int numOfDice) {
        int results = 0;
        for (int i = 0; i < numOfDice; i++) {
            results += rollDice();
        }
        return results;
    }
}
