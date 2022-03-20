package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    Map<String, CasinoAccount> casinoAccounts = new HashMap<>();
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        CasinoAccount tempAccount=casinoAccounts.get(accountName);
        if (tempAccount!=null){
            if (!accountPassword.equals(tempAccount.getAccountPassword()))
                System.out.println("Invalid password.");
            else if (accountPassword.equals(tempAccount.getAccountPassword()))
                return tempAccount;
        }
        else
            System.out.println("Account does not exist");
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword);
        registerAccount(newAccount);
        return newAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        casinoAccounts.put(casinoAccount.getAccountName(), casinoAccount);
    }

    public Person accountLogin() {
        boolean isValidLogin;
        CasinoAccount casinoAccount;
        do {
            String accountName = console.getStringInput("Enter your account name:");
            String accountPassword = console.getStringInput("Enter your account password:");
            casinoAccount = getAccount(accountName, accountPassword);
            isValidLogin = casinoAccount != null;
        } while (!isValidLogin);
        return casinoAccount.getProfile();
    }
}
