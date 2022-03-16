package com.github.zipcodewilmington.casino.games.ceelo;


import java.util.Random;

public class Dice {
    public static int[] rollDice(){
    int[] eachDice = new int[3];
    Random diceNumber= new Random();

    for (int i = 0; i< eachDice.length; i++) {
        eachDice[i] = diceNumber.nextInt(1,7);
    }
       return eachDice;


    }
}
