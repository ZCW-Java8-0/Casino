package com.github.zipcodewilmington.casino.games.ceelo;

import java.sql.Array;
import java.util.Random;

public class Rolldice {
    public static int[] rollDice(){
    int[] Dice = new int[3];
    Random diceNumber= new Random();


        Dice[0] = diceNumber.nextInt(6) + 1;
        Dice[1] = diceNumber.nextInt(6) + 1;
        Dice[2] = diceNumber.nextInt(6) + 1;

       int[] allDice = new Array.allDice[]={dice1, dice2, dice3};


    }
}
