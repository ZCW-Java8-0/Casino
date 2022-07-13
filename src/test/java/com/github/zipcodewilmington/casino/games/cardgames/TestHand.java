package com.github.zipcodewilmington.casino.games.cardgames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestHand {
    //List<PlayingCard> cards;
    Hand hand;

    @BeforeEach
    public void init() {
        List<PlayingCard> cards = new ArrayList<>(Arrays.asList(
                    new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                    new PlayingCard(CardSuit.CLUBS, CardRank.EIGHT),
                    new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK)));
        hand = new Hand(cards);
    }

    @Test
    public void constructorTest() {
        Hand newHand = new Hand();
        Integer expectedSize = 0;

        Integer actualSize = newHand.getNumberOfCards();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    void testGetCard() {
        CardSuit expectedSuit = CardSuit.CLUBS;
        CardRank expectedRank = CardRank.EIGHT;
        PlayingCard card = hand.getCard(1);

        CardSuit actualSuit = card.getSuit();
        CardRank actualRank = card.getRank();

        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    void testRemoveAndReturnCard() {
        PlayingCard card = hand.removeAndReturnCard(1);
        Integer expectedSize = 2;

        Integer actualSize = hand.getNumberOfCards();
        Assert.assertNotNull(card);
        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    void testGetCards() {
        List<PlayingCard> expectedCards = new ArrayList<>(Arrays.asList(
                new PlayingCard(CardSuit.CLUBS, CardRank.ACE),
                new PlayingCard(CardSuit.CLUBS, CardRank.EIGHT),
                new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK)));

        List<PlayingCard> actualCards = hand.getCards();

        for (int i = 0; i < expectedCards.size(); i++) {
            Assert.assertTrue(expectedCards.get(i).equals(actualCards.get(i)));
        }
    }

    @Test
    void testClearHand() {
        Integer expectedSize = 0;
        hand.clearHand();
        Integer actualSize = hand.getNumberOfCards();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    void testSwapCard() {
        PlayingCard expectedCard = new PlayingCard(CardSuit.HEARTS, CardRank.KING);
        hand.swapCard(expectedCard, 0);

        PlayingCard actualCard = hand.getCard(0);

        Assert.assertTrue(expectedCard.equals(actualCard));
    }

}