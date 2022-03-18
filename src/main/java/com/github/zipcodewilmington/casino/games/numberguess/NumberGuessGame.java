package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.interfaces.GameInterface;

import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface <NumberGuessPlayer>{

    Scanner scanner = new Scanner(System.in); //Scanner Class
    private final int num = 1 + (int) (10 * Math.random());// Computer Choice
    public static final String MSG_WINNER = "Jackpot!!!!!";
    public static final String MSG_TOO_HIGH = "Guess too high, the house wins!";
    public static final String MSG_TOO_LOW = "Guess too low, the house wins!";
    private boolean isOver = false;




    //Actual Game
    public String numberGuessGame(){
        do {
            System.out.println("Pick a number between 1 and 10");
            int guess = scanner.nextInt();
            scanner.close();
            return findWinner(guess, num);

        } while(!isOver);

    }

    public String findWinner(int guess, int num) {
        if (guess == num) {
            this.isOver = true;
            return MSG_WINNER;

        } else if (guess > num) {
            this.isOver = false;
            return MSG_TOO_HIGH;

        } else {
            this.isOver = false;
            return MSG_TOO_LOW;

        }
    }


    @Override
    public Boolean isOver() {
        return null;
    }

    @Override
    public void addPlayer(NumberGuessPlayer player) {

    }

    @Override
    public void addPlayers(List<? extends NumberGuessPlayer> player) {

    }

    @Override
    public void evaluateTurn(NumberGuessPlayer player) {

    }

    @Override
    public void remove(NumberGuessPlayer player) {

    }

    @Override
    public void run() {

    }
}