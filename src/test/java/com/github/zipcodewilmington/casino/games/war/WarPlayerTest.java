package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarPlayerTest {

    @Test
    void getCasinoAccount() {
        // Given
        String userName = "test";
        String password = "test123";
        CasinoAccountManager testMan = new CasinoAccountManager();
        testMan.createAccount(userName,password);
        WarPlayer testWarrior = new WarPlayer();

        // When
        CasinoAccount actual = testWarrior.getCasinoAccount();
        CasinoAccount expected = testMan.getAccountByUsername(userName);

        //Then
        assertEquals(actual,expected);

    }

    @Test
    void play() {
    }
}