package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CasinoAccountManagerTest {

    @Test
    void getAccount() {
    }

    @Test
    void createAccount() {
    }

    @Test
    void registerAccount() {
    }

    @Test
    void getCasinoAccount() {
    }

    @Test
    void getAccountByUsername() {
        // Given
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";

        // When
        testAccount = new CasinoAccount(accountName, accountPassword);
        testManager.registerAccount(testAccount);
        CasinoAccount expected = testAccount;
        CasinoAccount actual = testManager.getAccountByUsername(testAccount.getAccountName());
        // Then
        assertEquals(expected,actual);
    }
}