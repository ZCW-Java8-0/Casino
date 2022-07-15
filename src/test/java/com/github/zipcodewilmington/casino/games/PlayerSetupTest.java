package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.Account;
import com.github.zipcodewilmington.casino.PlayerSetup;
import org.junit.Assert;
import org.junit.Test;

public class PlayerSetupTest {
    @Test
    public void testAddActivePlayer() {
        Account account = new Account();
        PlayerSetup.addActivePlayer(account);
        int expected = 1;
        int actual = PlayerSetup.activePlayers.size();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testRemoveActivePlayer() {
        Account account = new Account();
        PlayerSetup.addActivePlayer(account);

        PlayerSetup.removeActivePlayer(account);
        int expected = 0;
        int actual = PlayerSetup.activePlayers.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testPlayerSetup() {



    }

}
