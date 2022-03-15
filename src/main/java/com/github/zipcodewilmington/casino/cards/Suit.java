package com.github.zipcodewilmington.casino.cards;

public enum Suit {
        HEARTS("Hearts"),
        SPADES("Spades"),
        CLUBS("Diamonds"),
        DIAMONDS("Clubs");

        private final String suitText;

        //Constructor
    private Suit(String suitText) {
        this.suitText = suitText;
    }


    //Public Method
    public String printSuit() {
        return suitText;
    }

}
