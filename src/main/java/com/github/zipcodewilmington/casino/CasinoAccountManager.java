package com.github.zipcodewilmington.casino;

import java.sql.SQLOutput;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 7/21/2020.
 * `CasinoAccountManager` stores, manages, and retrieves `CasinoAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private static Logger logger = Logger.getLogger(CasinoAccountManager.class.getName());
    private HashMap<String,CasinoAccount> accounts = new HashMap<>();
    List <CasinoAccount> casinoAccountList = new ArrayList<>();


    public CasinoAccountManager() {
        logger.log(Level.INFO,"Account Manager has been initialized.");
    }


    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `CasinoAccount` with specified `accountName` and `accountPassword` if none exists return null.
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        // if the accountName is not linked to a casino account warn user.
        if (!casinoAccountList.contains(getAccountByUsername(accountName))){
            System.out.println("This account has not been created yet.");
        } else {
            for (CasinoAccount account : casinoAccountList) {
                if (accountName.equals(account.getAccountName()) && accountPassword.equals(account.getAccountPassword())) {
                    return account;
                }
            }
            System.out.println("Your password does not match the account you are trying to access.");

        }
        return null;
    }
    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `CasinoAccount` with specified `accountName` and `accountPassword`
     */

    public CasinoAccount createAccount(String accountName,String accountPassword){
//
        CasinoAccount newAccount = new CasinoAccount (accountName, accountPassword);
        System.out.println("Your account has been created.");

        return newAccount;

    }

    /**
     * logs & registers a new `CasinoAccount` to `this.getCasinoAccountList()`
     *
     * @param casinoAccount the casinoAccount to be added to `this.getCasinoAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        String accountUsername = casinoAccount.getAccountName();
        casinoAccountList.add(casinoAccount);
        accounts.put(accountUsername,casinoAccount);

        System.out.println("Your account " + "\"" + casinoAccount.getAccountName() + "\"" + " has been registered.");
    }

    public CasinoAccount getAccountByUsername(String accountName){
        if (accounts.containsKey(accountName)){
            return accounts.get(accountName);
        }
        return null;
    }

    public List getCasinoAccount(){
        return casinoAccountList;
    }
}
