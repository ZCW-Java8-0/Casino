package com.github.zipcodewilmington.casino.games.cardgames;

public interface Deck {
    void shuffle();

    PlayingCard dealCard();


    int getDeckSize();

    void printCards();

}
