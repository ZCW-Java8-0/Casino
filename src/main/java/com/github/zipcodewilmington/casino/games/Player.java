package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.CasinoAccount;

public class Player {
    public String name;
    public static int balance;
    CasinoAccount casinoAccount;

    public Player(String name){
        this.name=name;
    }

    public Player(){}

    public String getName(){
        return this.name;
    }

    public static int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        Player.balance = balance;
    }
}
