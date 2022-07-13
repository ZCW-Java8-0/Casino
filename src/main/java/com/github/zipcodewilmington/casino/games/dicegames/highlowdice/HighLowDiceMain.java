package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import java.util.Scanner;

public class HighLowDiceMain {
    Scanner scanner = new Scanner(System.in);
    Integer results;


    public Integer checkHighOrLow(int diceResult) {
        if (diceResult > 7) {
            return 0; //High
        } else if (diceResult < 7){
            return 1; //Low
        }
        return 2; //7 is middle
    }
}
