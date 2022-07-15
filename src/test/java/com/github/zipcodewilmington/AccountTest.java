package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.PlayerSetup;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    @Test
    public void testSetAccountName(){
        Account account = new Account();
        account.setAccountName("Peter");
        String expected = "Peter";
        String actual = account.getAccountName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetName(){
        Account account = new Account();
        account.setName("Flo");
        String expected = "Flo";
        String actual = account.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetPassword(){
        Account account = new Account();
        account.setPassword("123");
        String expected = "123";
        String actual = account.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetBalance(){
        Account account = new Account();
        account.setBalance(2000);
        int expected = 2000;
        int actual = account.getBalance();
        Assert.assertEquals(expected, actual);
    }
    @Test
    //Constructor Test
    public void testAcctConstructor() {
        Account account = new Account("Gerald1", "Gerald", "432", 12345);

        String expAcctName = "Gerald1";
        String expName = "Gerald";
        String expPass = "432";
        int expBal = 12345;
        int actBal = account.getBalance();

        Assert.assertEquals(account.getAccountName(), expAcctName);
        Assert.assertEquals(account.getName(), expName);
        Assert.assertEquals(account.getPassword(), expPass);
        Assert.assertEquals(actBal, expBal);
    }
    @Test
    public void testAccountExists(){
        Account account1 = new Account("kyle", "kyle", "kyle", 100);
        boolean actual = Account.accountExists("kyle");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testMakeBet(){
        Account account = new Account("acctName", "name", "pass", 500);
        int actual = Account.makeBetTest(account, 200);
        int expected = 300;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDeposit(){
        Account account = new Account("troy", "troy", "troy", 100);
        Account.deposit(account, 100);
        int expected = 200;
        int actual = account.getBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testLogin() {
        PlayerSetup.activePlayers.clear();
        Account account = new Account("test", "test", "test", 100);
        Account.loginTest();

        int actual = PlayerSetup.activePlayers.size();
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }




}
