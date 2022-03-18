package com.github.zipcodewilmington.casino.games.Person;

public class Person {
    private String name;
    private int wallet;
    public Person(String name, int funds){
        this.name=name;
        this.wallet=funds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int funds) {this.wallet = funds;}
}
