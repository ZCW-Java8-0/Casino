package com.github.zipcodewilmington.casino.games.BlackJack;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck;

    public Deck(){
        this.deck = new Stack<>();
        for (int i=0; i<13;i++)
        {
            CardFace face = CardFace.values()[i];
            for (int j=0; j<4; j++)
            {
                Card card = new Card(face, Suit.values()[j]);
                this.deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }

    public Card getTopCard(){
        return deck.pop();
    }

    public int getSize() {
        return deck.size();
    }
}
