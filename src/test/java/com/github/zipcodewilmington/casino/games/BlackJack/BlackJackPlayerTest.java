package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.Person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackPlayerTest {
    Person person = new Person("name", 0);
    BlackJackPlayer blackJackPlayer = new BlackJackPlayer(person);

    @Test
    void addWinning() {
        //When
        blackJackPlayer.addWinning(10);
        int expected = 10;
        int actual = blackJackPlayer.getBalance();
        //Then
        Assertions.assertEquals(expected,actual);
    }


    @Test
    void applyBet() {
        //When
        blackJackPlayer.applyBet(10);
        int expected = -10;
        int actual = blackJackPlayer.getBalance();
        //Then
        Assertions.assertEquals(expected,actual);
    }
}