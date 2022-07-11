package com.github.zipcodewilmington.casino.games.cardgames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestStandardDeck {
    StandardDeck deck;
    @Before
    public void init() {
        deck = new StandardDeck();
    }
    @Test
    public void testShuffleWithGivenCards() {
        List<PlayingCard> cards = deck.initCards();
        List<PlayingCard> cardsCopy = new ArrayList<>(cards);

        deck.shuffle(cards);

        Assert.assertNotEquals(cards, cardsCopy);
    }

    @Test
    public void testShuffle() {
        Deque<PlayingCard> expectedOriginal = new ArrayDeque<>(deck.getCards());
        deck.shuffle();
        Deque<PlayingCard> actualShuffled = deck.getCards();

        for (int i = 0; i < 3; i++) {
            Assert.assertNotEquals(expectedOriginal.removeFirst(), actualShuffled.removeFirst());
        }
    }

    @Test
    public void dealCard() {
        PlayingCard card = deck.dealCard();
        Integer expectedSize = 51;

        Integer actualSize = deck.getCards().size();
        Assert.assertNotNull(card);

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void insertCardFromBottom() {
        PlayingCard expectedCard = deck.dealCard();

        deck.insertCardFromBottom(expectedCard);

        PlayingCard actualCard = deck.getCards().removeLast();

        Assert.assertEquals(expectedCard, actualCard);
    }

    @Test
    public void getDeckSize() {
        Integer expectedSize = 52;

        Integer actualSize = deck.getDeckSize();

        Assert.assertEquals(expectedSize, actualSize);
    }
}