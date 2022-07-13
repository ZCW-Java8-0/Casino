package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Account;
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
}
