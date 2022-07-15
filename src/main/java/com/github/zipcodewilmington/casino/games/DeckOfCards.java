package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards  {
    private ArrayList<Card> deck;



    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> shuffle(){
        Collections.shuffle(deck);
        return deck;
    }

    public int size(){
        return deck.size();
    }

    public Card get(int i){
        return deck.get(i);
    }

    public Card draw(){
        return deck.remove(0);
    }

    public DeckOfCards(){
        List<String> suits = Card.getValidSuits();

        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<>();

        for (String suit: suits){
            for (String faceName: faceNames){
                deck.add(new Card(faceName, suit));
            }
        }
    }
}
