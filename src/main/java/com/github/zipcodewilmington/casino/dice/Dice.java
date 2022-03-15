package com.github.zipcodewilmington.casino.dice;

import java.util.ArrayList;
import java.util.Arrays;

public class Dice {
    ArrayList<Integer> roll = new ArrayList<>();
    int numDice;

    public Dice (int numDice) {
        this.numDice = numDice;
    }

    public int roll(){
     for (int i = 0; i < numDice; i++) {
        roll.set(i, (int) Math.floor(Math.random() * 6 + 1));

    }
        return Integer.parseInt(Arrays.toString(roll.toArray()));
    }

}
