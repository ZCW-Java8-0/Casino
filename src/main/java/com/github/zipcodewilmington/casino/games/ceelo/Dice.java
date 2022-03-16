package com.github.zipcodewilmington.casino.games.ceelo;


import com.github.zipcodewilmington.casino.games.BlackJack.Deck;

import java.util.Arrays;
import java.util.Random;

public class Dice {

    public static int[] rollDice(Random diceNumber){
        int[] eachDice = new int[3];

        for (int i = 0; i< eachDice.length; i++) {
            eachDice[i] = diceNumber.nextInt(1,7);
            
    }
        Arrays.sort(eachDice);
        for (int i = 0; i< eachDice.length; i++) {
            System.out.println(eachDice[i]);// to see dice value
        }

        return eachDice;


    }
}
