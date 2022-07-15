package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.PlayerSetup;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessMain {
    static boolean running = true;
    static int input;
    static NumberGuessEngine guessEngine = new NumberGuessEngine();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        PlayerSetup.playerSetup(1);

        while(running){
            guessEngine.prompt();
            guessEngine.promptForGuess();
            input = scanner.nextInt();
            if(guessEngine.checkNumber(input) == true){
                System.out.println("Congrats you won!!!");
            } else {
                System.out.println("Unfortunately you lost.");
            }

            guessEngine.promptContinue();
            if(input == 1){
                continue;
            } else if (input == 2) {
                running = false;
            }
        }

    }
}