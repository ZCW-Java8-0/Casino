package com.github.zipcodewilmington.casino.games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards extends ArrayList {
    private ArrayList<Card> deck;



    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> shuffle(){
            Collections.shuffle(deck);
        return deck;
    }


    public DeckOfCards(){
        List<String> suits = Card.getValidSuits();

        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<Card>();

        for (String suit: suits){
            for (String faceName: faceNames){
                deck.add(new Card(faceName, suit));
            }
        }
    }
}
