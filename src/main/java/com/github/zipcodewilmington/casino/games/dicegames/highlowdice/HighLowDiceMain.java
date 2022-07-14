package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.casino.games.dicegames.Dice;

import java.util.Scanner;

import static com.github.zipcodewilmington.casino.games.dicegames.highlowdice.HighLowDiceEngine.*;

public class HighLowDiceMain {
    static Scanner scanner = new Scanner(System.in);
    int results;
    int highOrLow;
    static boolean running = true;
    static Dice dice = new Dice();
    static HighLowDiceEngine mainGame = new HighLowDiceEngine();


    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        while(running) {
            startPrompt();
            instructionsPrompt();
            placeBets();
            dice.tossAndSum(2);
            int highOrLow = mainGame.checkHighOrLow(dice.getResults());
            resolveBets();
            running = false;
        }
    }


}
