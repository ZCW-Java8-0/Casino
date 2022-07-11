package com.github.zipcodewilmington.casino.games.highlowdice;

import java.util.Scanner;

public class HighLowDiceGame {
    int numOfDice = 2;
    int results;
    int bet;
    int players;


    Dice dice = new Dice();

    public void playGame() {
        while(true) {
            System.out.println("Welcome to High Low Dice Game\n");
            System.out.println("Please choose from the following: 1) Play Game 2) Quit\n");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if(input == 1) {
                System.out.println("How many players?");
                players = scanner.nextInt();
                //Store players
                //determine which player goes first

            } else if (input == 2) {
                break;
            }
        }
    }
}
