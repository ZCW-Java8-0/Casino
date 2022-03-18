package com.github.zipcodewilmington.casino.games.BlackJack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class DeckTest {
    Deck deck = new Deck();

    @Test
    void getSize() {
        //When
        int expected = 52;
        int actual = deck.getSize();
        //Then
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void getTopCard() {
        //Given
        Map<CardFace, Integer> facecount = new HashMap<>();
        Map<Suit, Integer> suitCount = new HashMap<>();
        Card temp;
        //When
        for (int i=0;i<52;i++){
            temp=deck.getTopCard();
            if (facecount.get(temp.getCardFace())==null)
                facecount.put(temp.getCardFace(),1);
            else
                facecount.put(temp.getCardFace(), facecount.get(temp.getCardFace())+1);
            if (suitCount.get(temp.getSuit())==null)
                suitCount.put(temp.getSuit(),1);
            else
                suitCount.put(temp.getSuit(), suitCount.get(temp.getSuit())+1);
        }
        //Then
        Assertions.assertTrue(deck.getSize()==0);
        Assertions.assertEquals(4,suitCount.size());
        Assertions.assertEquals(13, facecount.size());
    }
}