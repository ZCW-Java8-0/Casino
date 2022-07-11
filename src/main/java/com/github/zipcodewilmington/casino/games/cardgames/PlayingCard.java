package com.github.zipcodewilmington.casino.games.cardgames;

public class PlayingCard {
    private final CardSuit SUIT;
    private final CardRank RANK;

    public PlayingCard(CardSuit suit, CardRank rank) {
        this.SUIT = suit;
        this.RANK = rank;
    }

    public CardSuit getSuit() {
        return SUIT;
    }

    public CardRank getRank() {
        return RANK;
    }

    // TODO: Add console graphic representation of card
    public void printCard() {}

}

