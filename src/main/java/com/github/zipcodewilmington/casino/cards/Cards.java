package com.github.zipcodewilmington.casino.cards;


public class Cards {
    //Private Fields
    private final Suit suit;
    private final Rank rank;
    private int tier;


    //Constructor
    public Cards(Rank rank, Suit suit, int tier) {
        this.rank = rank;
        this.suit = suit;
        this.tier = tier;
    }
}


