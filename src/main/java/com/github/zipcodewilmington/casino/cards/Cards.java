package com.github.zipcodewilmington.casino.cards;

import java.util.ArrayList;

public class Cards {
    //Private Fields
    private final Suit suit;
    private final Rank rank;
    private int tier;
    private ArrayList<Cards> cardDeck = new ArrayList<>();

    //Constructor
    public Cards(Rank rank, Suit suit, int tier) {
        this.rank = rank;
        this.suit = suit;
        this.tier = tier;
    }



    // Methods
    public ArrayList<Cards> createDeck() {
        for (int i = 1; i < 15; i++) {
            switch (i) {
                case 1:
                    for (Rank rank:Rank.values()
                         ) {cardDeck.add(new Cards(rank, Suit.HEARTS, i++));
                    } i = 1;
                case 15:
                    for (Rank rank:Rank.values()
                         ) {cardDeck.add(new Cards(rank, Suit.SPADES, i++));
                }i = 1;
                case 30:
                    for (Rank rank:Rank.values()
                         ) {cardDeck.add(new Cards(rank, Suit.DIAMONDS, i++));
                }i = 1;
                case 45:
                    for (Rank rank:Rank.values()
                         ) {cardDeck.add(new Cards(rank, Suit.CLUBS, i++));
                }i = 1;
            }
            System.out.println(cardDeck);
        } return cardDeck;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "suit=" + suit +
                ", rank=" + rank +
                ", tier=" + tier +
                ", cardDeck=" + cardDeck +
                '}';
    }


}


