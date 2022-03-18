package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CasinoAccountManagerTest {

    @Test
    void getAccount() {
        // Given
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";

        // When
        testAccount = new CasinoAccount(accountName, accountPassword);
        testManager.registerAccount(testAccount);
        CasinoAccount expected = testAccount;
        CasinoAccount actual = testManager.getAccount(accountName,accountPassword);
        // Then
        assertEquals(expected,actual);
    }
    @Test
    void getAccountForUnregisteredAccount() {
        // Given
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";

        // When
        testAccount = new CasinoAccount(accountName, accountPassword);
        CasinoAccount expected = null;
        CasinoAccount actual = testManager.getAccount(accountName,accountPassword);
        // Then
        assertEquals(expected,actual);
    }
    @Test
    void getAccountForErroneousPassword() {
        // Given
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";
        String wrongPassword = "123test";

        // When
        testAccount = new CasinoAccount(accountName, accountPassword);
        testManager.registerAccount(testAccount);
        CasinoAccount expected = null;
        CasinoAccount actual = testManager.getAccount(accountName,wrongPassword);
        // Then
        assertEquals(expected,actual);
    }

    @Test
    void createAccount() {
        // Given
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount;
        String accountName = "test";
        String accountPassword = "test123";

        // When
        testAccount = testManager.createAccount(accountName,accountPassword);
        boolean expected = testManager.getCasinoAccountList().contains(testAccount);
        // Then
        assertTrue(expected);
    }

    @Test
    void createAccountWhenNotCreatedThroughManager() {
        // Given
        String accountName = "test";
        String accountPassword = "test123";
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        CasinoAccountManager testManager = new CasinoAccountManager();
        // When
        boolean expected = testManager.getCasinoAccountList().contains(testAccount);
        // Then
        assertFalse(expected);
    }
//
    @Test
    void registerAccount() {
        // Given
        String accountName = "test";
        String accountPassword = "test123";
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);
        CasinoAccountManager testManager = new CasinoAccountManager();
        // When
        testManager.registerAccount(testAccount);
        boolean expected = testManager.getCasinoAccountList().contains(testAccount);
        // Then
        assertTrue(expected);
    }

    @Test
    void getCasinoAccount() {
        // Given
        String accountName = "test";
        String accountPassword = "test123";
        CasinoAccountManager testManager = new CasinoAccountManager();
        CasinoAccount testAccount = new CasinoAccount(accountName, accountPassword);

        // When
        testManager.registerAccount(testAccount);

        System.out.println(testManager.getCasinoAccountList());
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