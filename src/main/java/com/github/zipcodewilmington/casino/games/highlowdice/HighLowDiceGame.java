package com.github.zipcodewilmington.casino.games.highlowdice;

import java.util.Scanner;

public class HighLowDiceGame {
    int numOfDice = 2;
    int results;
    int bet;
    int players;
    int[] high = new int[]{2, 3, 4, 5, 6};
    int[] low = new int[]{8,9,10,11,12};
    Dice dice = new Dice();

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            prompt();
            int input = scanner.nextInt();
            if(input == 1) {
//                System.out.println("How many players?");
//                players = scanner.nextInt();
                //Store players
                //determine which player goes first
                System.out.println("Place your bets");
                bet = scanner.nextInt();
                System.out.println("High or Low or 7? enter 1 for High, 2 for low, 3 for 7");

                int highOrLow = scanner.nextInt();
                if(highOrLow == 1) {
                    //store player in high
                } else if (highOrLow == 2) {
                    //store player in low
                } else {
                    //store player in 7
                }
                results = dice.tossAndSum(2);
                //compare results to high and low
//                for (int i = 0; i < 5; i++){
//                    if(high[i] == results){
//                        System.out.println("high wins");
//                        //player with bets on high gets paid
//                    } else if (low[i] == results) {
//                        System.out.println("low wins");
//                        //player with bets on low gets paid
//                    }
//                }
                checkHighOrLow();
                System.out.println("Would you like to keep playing? Y or N\n");
                String yn = scanner.next();
                if (yn.equals('y')){
                    continue;
                } else {
                    //add/subtract earnings/loss
                    break;
                }
            } else if (input == 2) {
                break;
            }
        }
    }

    public int checkHighOrLow() {
        int hilo = 0;
        //Checks for if the results is high or low or 7.
        for (int i = 0; i < 5; i++){
            if(high[i] == results){
                hilo = 1; //high
            } else if (low[i] == results) {
                hilo = 2; //low
            } else hilo = 0; // 7
        }
        return hilo;
    }

    public void prompt() {
        System.out.println("Welcome to High Low Dice Game\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\n Enter 1 or 2 \n");
    }
}
