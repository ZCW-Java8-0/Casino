package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.Random;

public class NumberGuessEngine {
    private Random random = new Random();
    private Integer number;

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer guessNumber(){
        this.number = random.nextInt(10) + 1;
        return this.number;
    }

    public boolean checkNumber(int number) {
        if (number == guessNumber()){
            return true;
        } else return false;
    }

    public void prompt(){
        System.out.println("Welcome to the Number Guessing Game!\nWe do not accept your money here\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\nEnter 1 or 2 \n");
    }

    public void promptForGuess() {
        System.out.println("Please guess a number between 1 - 10\n");
    }

    public void promptContinue() {
        System.out.println("Do you want to continue playing?\n1) Continue 2) Quit\n");
    }
}
