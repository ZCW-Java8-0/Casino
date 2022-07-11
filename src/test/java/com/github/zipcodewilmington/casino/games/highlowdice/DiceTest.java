package com.github.zipcodewilmington.casino.games.highlowdice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() {
        Dice dice = new Dice();
        boolean isTrue = false;
        dice.rollDice();

        if(dice.rollDice() == 1 || dice.rollDice() == 2 || dice.rollDice() == 3 || dice.rollDice() == 4 || dice.rollDice() == 5  || dice.rollDice() == 6){
            isTrue = true;
        }

        Assertions.assertEquals(true, isTrue);
    }

    @Test
    void tossAndSum() {
        Dice dice = new Dice();
        dice.tossAndSum(2);
        boolean isTrue = false;

        if(dice.tossAndSum(2) == 2 || dice.tossAndSum(2) == 3 || dice.tossAndSum(2) == 4 || dice.tossAndSum(2) == 5 || dice.tossAndSum(2) == 6 || dice.tossAndSum(2) == 7 || dice.tossAndSum(2) == 8  || dice.tossAndSum(2) == 9  || dice.tossAndSum(2) == 10  || dice.tossAndSum(2) == 11  || dice.tossAndSum(2) == 12){
            isTrue = true;
        }


        Assertions.assertEquals(true, isTrue);
    }
}