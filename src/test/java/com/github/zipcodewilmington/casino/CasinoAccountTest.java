package com.github.zipcodewilmington.casino;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CasinoAccountTest {
    //Pre-sets
    CasinoAccount testAccount;

    @Test
    void getAccountName() {

        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        testAccount = new CasinoAccount(accountName, accountPassword);
        // When
        String expected = accountName;
        String actual = testAccount.getAccountName();
        // Then
        assertEquals(expected,actual);
    }

    @Test
    void getAccountByUsername() {
        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        testAccount = new CasinoAccount(accountName, accountPassword);
        // When
        CasinoAccount expected = testAccount;
        CasinoAccount actual = casinoAccount.getAccountByUsername();
        // Then
        assertEquals(expected,actual);
    }

    @Test
    void getAccountPassword() {
        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        // When
        // Then
    }

    @Test
    void setAccountPassword() {
        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        // When
        // Then
    }

    @Test
    void getAccountBalance() {
        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        // When
        // Then
    }

    @Test
    void setAccountBalance() {
        // Given
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        // When
        // Then
    }
}