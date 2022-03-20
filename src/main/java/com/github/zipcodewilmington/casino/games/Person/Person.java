package com.github.zipcodewilmington.casino.games.Person;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID= 3L;
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
