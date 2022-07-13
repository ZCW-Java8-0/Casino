package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import java.util.Scanner;

public class HighLowDiceMain {
    Scanner scanner = new Scanner(System.in);
    Integer results;


    public static Integer placeBets() {

        return null;
    }
    public static Integer resolveBets() {

        return null;
    }
    public Integer checkHighOrLow(int diceResult) {
        if (diceResult > 7) {
            return 0; //High
        } else if (diceResult < 7){
            return 1; //Low
        }
        return 2; //7 is middle
    }
    public static void startPrompt() {
        System.out.println("Welcome to High Low Dice Game\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\nEnter 1 or 2 \n");
    }

    public static void instructionsPrompt() {
        System.out.println("Rules!\nThe outcome is considered:\nHigh if the sum of the dice is 8, 9, 10, 11, 12.\nLow if the sum of the dice is 1, 2, 3, 4, 5, 6.\nSeven is the outcome is 7.\n\nPlace your bets on High, Low, or Seven\nPayout is 1-1 for High and Low.\nPayout is 4-1 for Seven.\n");
    }
}
