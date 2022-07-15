package com.github.zipcodewilmington.casino.games.numberguess;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

class NumberGuessEngineTest {

    @Test
    void guessNumberTest() {
            NumberGuessEngine engine = new NumberGuessEngine();
            Random random = new Random(1);
            engine.setRandom(random);

            Integer expected = 6;
            Integer actual = engine.guessNumber();

            Assert.assertEquals(expected, actual);

    }
}