package com.github.zipcodewilmington.abstractclasses;

import java.util.Scanner;

public abstract class WagingGame  {
    int bet;
    Scanner scanner = new Scanner(System.in);


    public void setBet(){
        System.out.println("How much would you like to wager? \n");
        int bet = scanner.nextInt();
    }

    public int getBet(){
        return bet;
    }

}
