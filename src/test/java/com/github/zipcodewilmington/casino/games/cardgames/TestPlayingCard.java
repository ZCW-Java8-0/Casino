package com.github.zipcodewilmington.casino.games.cardgames;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPlayingCard {
    PlayingCard card;
    @Before
    public void setUp() {
        card = new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK);
    }

    @Test
    public void testGetSuit() {
        String expected = "DIAMONDS";

        String actual = card.getSuit().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRank() {
        String expected = "JACK";

        String actual = card.getRank().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        PlayingCard newCard = new PlayingCard(CardSuit.DIAMONDS, CardRank.JACK);
        Boolean expected = true;

        Boolean actual = newCard.equals(card);

        Assert.assertEquals(expected, actual);
    }
}