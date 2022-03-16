package com.github.zipcodewilmington.casino.games.ceelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() {
        //when
        Dice dice = new Dice();
        Random diceNumber = new Random();
//        Random diceNumber= new Random();
        //then
        int[] actual = Dice.rollDice(diceNumber);
        for (int j : actual) {
        //
        Assert.assertTrue(j > 0 && j < 7);
        }
    }
    @Test
    void rollDiceFalse() {
        Dice dice = new Dice();

        Random diceNumber = new Random();

        int[] actual = Dice.rollDice(diceNumber);
        for (int i = 0; i < actual.length; i++) {
            Assert.assertFalse(actual[i] > 0 && actual[i] > 7);
        }
    }
}