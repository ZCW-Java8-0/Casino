package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.PlayerSetup;
import com.github.zipcodewilmington.casino.games.dicegames.Dice;

import java.util.Scanner;

import static com.github.zipcodewilmington.casino.PlayerSetup.activePlayers;
import static com.github.zipcodewilmington.casino.games.dicegames.highlowdice.HighLowDiceEngine.*;

public class HighLowDiceMain {
    static Scanner scanner = new Scanner(System.in);
    static int results;
    static boolean running = true;
    static Dice dice = new Dice();
    static HighLowDiceEngine mainGame = new HighLowDiceEngine();


    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        PlayerSetup.playerSetup(2);


        while (running) {
            startPrompt();
            instructionsPrompt();
            placeBets();
            System.out.println("Enter a number: 1) High 2) Low 3) Seven\n");
            //take input per player. set player input to 0 for high, 1 for low, 2 for seven
            dice.tossAndSum(2);
            int highOrLow = mainGame.checkHighOrLow(dice.getResults());
            if(highOrLow == 0){
                results = 0; //0 is high
            } else if (highOrLow == 1){
                results = 1; //1 is low
            } else if (highOrLow == 2) {
                results = 2; //2 is seven
            }

//            if(results == 2 && playerInput == results){
//                resolveBets(); //Seven = 4-1 payout
//            } else if(playerInput == results){
//                resolveBets();
//            }
//
//            System.out.println("Do you want to continue playing?\n1) Continue 2) Quit\n");
//            if(input == 1){
//                continue;
//            } else if (input == 2) {
//                running = false;
//            }
        }
    }


}
