package com.github.zipcodewilmington.casino.dice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.github.zipcodewilmington.casino.dice.Dice.roll;
import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void roll() {
        //given
        Dice.numDice = 2;
        //when
        int expected = 2;
        //then
        int actual = roll.size();
        assertEquals(expected, actual);
    }
}