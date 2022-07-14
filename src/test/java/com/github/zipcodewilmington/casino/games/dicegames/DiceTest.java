package com.github.zipcodewilmington.casino.games.dicegames;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class DiceTest {
    @Test
    void rollDiceTest() {
        Dice dice = new Dice();
        Random random = new Random(1);
        dice.setRandom(random);

        Integer expected = 4;
        Integer actual = dice.rollDice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void tossAndSum() {
        Dice dice = new Dice();
        Random random = new Random(2);
        dice.setRandom(random);

        Integer expected = 6;
        Integer actual = dice.tossAndSum(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getNumberTest() {
        Dice dice = new Dice();
        int expected = dice.rollDice();

        int actual = dice.getNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getResultTest() {
        Dice dice = new Dice();
        int expected = dice.tossAndSum(2);

        int actual = dice.getResults();

        Assert.assertEquals(expected, actual);
    }
}