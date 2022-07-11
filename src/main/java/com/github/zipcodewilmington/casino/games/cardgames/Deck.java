package com.github.zipcodewilmington.casino.games.cardgames;

public interface Deck {
    void shuffle();

    PlayingCard dealCard();


    int getDeckSize();

    // reset Deck to a new shuffled state
    void reset();

    void printCards();

}
