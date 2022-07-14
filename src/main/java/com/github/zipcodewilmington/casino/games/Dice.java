package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    static List<Integer> bins;
    private Integer numOfDice;
    private Integer maxRoll = numOfDice * 6;
    private Integer sum;

    public Dice(Integer dice) {
        this.numOfDice = dice;
    }

    public int tossAndSum(){

        // Roll n amount of times and return the sum of the rolls.

        int result = 0;
        for (int i = 0; i < numOfDice; i++) {
            result += (6 * Math.random() + 1);
        }
        return result;
    }

    // create an ArrayList populated with 0's. Number of elements depends on number of dice.

    public void initializeBins() {
        bins = new ArrayList<Integer>();
        for (int i = numOfDice; i < (maxRoll + numOfDice); i++){
            bins.add(0);
        }
    }

    //return bin for a specified value

    public Integer getBin(Integer number){
        return bins.get(number);
    }

    public void incrementBin(int sum) {
        bins.set(sum, getBin(sum)+1);
    }

}
