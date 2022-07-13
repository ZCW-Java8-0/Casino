package com.github.zipcodewilmington.casino.games.dicegames;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.games.dicegames.highlowdice.HighLowDiceMain;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class HighLowDiceTest {
    @Test
    public void checkHighOrLowTest(){
        Dice dice = new Dice();
        int results = dice.tossAndSum(2);
        HighLowDiceMain mainGame = new HighLowDiceMain();

        int expected = mainGame.checkHighOrLow(results);
        int actual = 1;

        Assert.assertEquals(expected, actual);

    }



}
