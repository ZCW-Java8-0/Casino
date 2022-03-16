package com.github.zipcodewilmington.casino.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public static ArrayList<Cards> cardDeck = new ArrayList<>();


    //Methods
    public static ArrayList<Cards> createDeck() {
        ArrayList<Cards> cardDeck = new ArrayList<>(0);
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

        } return cardDeck;
    }

    public void shuffle(){
        Collections.shuffle(cardDeck);
        System.out.println(cardDeck);
    }

    @Override
    public String toString() {
        StringBuilder str  = new StringBuilder();
        for (Cards cards : cardDeck) {
            str.append(cards);
        }
            return null;
        }

//        return "Cards{" +
//                "suit=" + Suit.suit +
//                ", rank=" + Rank.rank +
//                ", tier=" + Cards.tier +
//                ", cardDeck=" + cardDeck +
//                '}';



}
