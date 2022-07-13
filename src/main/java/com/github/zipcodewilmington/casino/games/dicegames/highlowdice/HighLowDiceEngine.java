package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import com.github.zipcodewilmington.casino.games.dicegames.Dice;

import java.util.Scanner;

public class HighLowDiceEngine extends Dice {
    static Scanner scanner = new Scanner(System.in);
    int numOfDice = 2;
    int results;

    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {
        while(true) {
            prompt();


        }
    }


    public static void prompt() {
        System.out.println("Welcome to High Low Dice Game\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\n Enter 1 or 2 \n");
    }


}
