package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.casino.games.dicegames.Dice;

import java.util.Scanner;

public class HighLowDiceEngine extends Dice {
    static Scanner scanner = new Scanner(System.in);
    int results;
    int highOrLow;
    static Dice dice = new Dice();
    static HighLowDiceMain mainGame = new HighLowDiceMain();


    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        while(true) {
            //prompt();
            //System.out.println("Place your bets");
            int results = dice.tossAndSum(2);
            int highOrLow = mainGame.checkHighOrLow(results);
        }
    }
    public static void prompt() {
        System.out.println("Welcome to High Low Dice Game\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\n Enter 1 or 2 \n");
    }

}
