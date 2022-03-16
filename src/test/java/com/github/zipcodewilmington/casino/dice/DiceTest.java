package com.github.zipcodewilmington.casino.dice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.github.zipcodewilmington.casino.dice.Dice.roll;

class DiceTest {

    @Test
    public void rollTest() {
        //given
        int expected = 2;
        //when

        ArrayList<Integer> actualRoll = Dice.roll(2);
        int actual = actualRoll.size();

        //then

        Assert.assertEquals(expected, actual);
    }
}