package com.github.zipcodewilmington.casino.cards;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    @Test
    void getSuit() {
        //given
    String expected = "Hearts, Spades, Diamonds, Clubs";;
        //when

         String actual = "Hearts, Spades, Diamonds, Clubs";
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getRank() {
        //given
        int expected = 2;
        //when
        int actual = 5;
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        //given

        //when

        //then
    }
}