package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.Person.Person;

import java.io.Serializable;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount implements Serializable {
    private final String accountName;
    private String accountPassword;
    private Person profile;
    private static final long serialVersionUID= 2L;

    public CasinoAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
    }

    public String getAccountName(){
        return accountName;
    }

    public String getAccountPassword(){
        return accountPassword;
    }

    public void createProfile(String name, Integer funds) {
        this.profile = new Person(name, funds);
    }

    public Person getProfile() {
        return profile;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public void addFunds(Integer funds) {
        profile.setWallet(profile.getWallet()+funds);
    }
}
