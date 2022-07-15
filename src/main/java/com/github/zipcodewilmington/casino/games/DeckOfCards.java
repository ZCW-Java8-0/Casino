package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards  {
    private ArrayList<Card> deck;
    private Card drawnCard;
    private boolean blackJackTrueWarFalse;
    private ArrayList<Integer> deckSelector;
    private ArrayList<Integer> warValues = (ArrayList<Integer>) Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    private ArrayList<Integer> blackJackValues = (ArrayList<Integer>) Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11);

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
        drawnCard = deck.get(0);
        deck.remove(0);
        return drawnCard;
    }

    public DeckOfCards(boolean blackJackTrueWarFalse){
        if(blackJackTrueWarFalse == true){
            deckSelector.addAll(blackJackValues);
        }
        else{
            deckSelector.addAll(warValues);
        }

        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<>();

        for (String suit: suits){
            for (String faceName: faceNames){
                deck.add(new Card(faceName, suit, 1));
            }
//            for (int i = 0; i < deck.size();i++){
//                deck.set(i, );
//            }
        }
    }
}
