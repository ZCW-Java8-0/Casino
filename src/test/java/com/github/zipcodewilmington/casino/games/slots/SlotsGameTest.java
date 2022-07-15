package com.github.zipcodewilmington.casino.games.slots;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SlotsGameTest {

    @Test
    public void randomNumber(){
        Random rand = new Random(1);
        int expected = rand.nextInt(10);
        int actual = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomNumber1(){
        Random rand = new Random(2);
        int expected = rand.nextInt(10);
        int actual = 8;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomNumber2(){
        Random rand = new Random(3);
        int expected = rand.nextInt(10);
        int actual = 4;
        Assert.assertEquals(expected, actual);
    }

}