package com.github.zipcodewilmington.casino;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by leon on 7/21/2020.
 * `CasinoAccount` is registered for each user of the `Casino`.
 * The `CasinoAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount{
    private final String accountName;
    private String accountPassword;
    private HashMap<String,CasinoAccount> accounts = new HashMap<>();
    private Integer accountBalance;

    protected CasinoAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        accounts.put(accountName, this);
        this.accountBalance = 50000;
    }



    public String getAccountName() {
        return accountName;
    }

    public CasinoAccount getAccountByUsername(String accountName){
        if (accounts.containsKey(accountName)){
            return accounts.get(accountName);
        }
        return null;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }


}
