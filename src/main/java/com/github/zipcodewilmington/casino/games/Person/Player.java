package com.github.zipcodewilmington.casino.games.Person;

public abstract class Player {
    private Person person;
    public Player(Person person){
        this.person=person;
    }

    public Person getPerson() {
        return person;
    }
}
