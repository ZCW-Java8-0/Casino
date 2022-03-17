package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;

import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface<NumberGuessPlayer> {

    Scanner scanner = new Scanner(System.in); //Scanner Class
    int num = 1 + (int) (10 * Math.random());// Computer Choice
    int guessCount = 0;
    int previousGuess = 11;
    //Actual Game
        while(true)

    {

        {
            System.out.println("Pick a number between 1 and 10");
            int guess = scanner.nextInt();
            if (guess == num) {
                guessCount += 1;
                System.out.println("Congratulations! You guessed the number!");
                System.out.println("You guessed in" + " " + guessCount + " " + "tries!");
                break;
            } else if (guess > num) {
                System.out.println("Guess is too high, pick again");
                if (previousGuess != guess) {
                    guessCount += 1;
                    previousGuess = guess;
                }
            } else {
                System.out.println("Guess is too low, pick again");
                if (previousGuess != guess) {
                    guessCount += 1;
                    previousGuess = guess;
                }
            }
            scanner.close();
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