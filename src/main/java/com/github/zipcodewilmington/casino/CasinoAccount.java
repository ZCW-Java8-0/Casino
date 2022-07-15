package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    String userName;
    String password;
    Integer accountBalance;

    public CasinoAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public CasinoAccount(String userName, String password, Integer balance) {
        this.userName = userName;
        this.password = password;
        this.accountBalance = balance;
    }
    public void updateAccountBalance(Integer amount) {
        this.accountBalance += amount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

}
