package com.github.zipcodewilmington.casino;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CasinoAccountTest {
    //Pre-sets
    String accountName = "test";
    String accountPassword = "test123";


    @Test
    void getAccountName() {

        // Given
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        // When
        String expected = accountName;
        String actual = testAccount.getAccountName();
        // Then
        assertEquals(expected,actual);
    }


    @Test
    void getAccountPassword() {
        // Given
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        String accountName = "test";
        String accountPassword = "test123";
        // When
        String expected = accountPassword;
        String actual = testAccount.getAccountPassword();
        // Then
        assertEquals(expected,actual);
    }

    @Test
    void setAccountPassword() {
        // Given
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        String accountName = "test";
        String accountPassword = "test123";
        String newPassword = "123test";
        // When
        String expected = newPassword;
        testAccount.setAccountPassword(newPassword);
        String actual = testAccount.getAccountPassword();
        // Then
        assertEquals(expected,actual);
    }

    @Test
    void setAccountBalance() {
        // Given
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        // When
        int expected = 32000;
        testAccount.setAccountBalance(expected);
        int actual = testAccount.getAccountBalance();
        // Then
        assertEquals(expected,actual);
    }


}