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

        boolean actual = false;
        if(mainGame.checkHighOrLow(results) == 0 || mainGame.checkHighOrLow(results) == 1 || mainGame.checkHighOrLow(results) == 2){
            actual = true;
        }

        Assert.assertTrue(actual);

    }
    @Test
    public void placeBetTest(){

    }
    @Test
    public void resolveBetTest(){

    }

}
