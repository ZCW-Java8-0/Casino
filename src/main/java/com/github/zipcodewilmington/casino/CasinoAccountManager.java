package com.github.zipcodewilmington.casino;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    CasinoAccount[] accounts;

    public CasinoAccountManager(CasinoAccount...accounts){
        this.accounts = accounts;
    }

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        String currentClassName = getClass().getName();
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }
}
