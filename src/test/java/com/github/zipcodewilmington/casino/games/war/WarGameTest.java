package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.cards.Cards;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WarGameTest {

    @Test
    void createWarDeck() {
        // Given
        int expected = 52;
        WarGame warGame = new WarGame();
        // When
        ArrayList<Cards> arrayListOfCards = warGame.createWarDeck();
        int actual = arrayListOfCards.size();
        // Then
        Assert.assertTrue(expected == actual);
        System.out.println(arrayListOfCards);
        // test for 52 items in arraylist
        // contains ???
        // sout
    }

    @Test
    void shuffle() {
    }
}