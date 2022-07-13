package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.HashMap;
import java.util.Map;

public class PlayerSetup {
    public static Map<String, Integer> activePlayers = new HashMap<>();
    // ^^ Hashmap of active players.  <Name, Balance>


    public static boolean addActivePlayer(String account, Integer balance){
        activePlayers.put(account, balance);
        if (activePlayers.containsKey(account) == true){return false;}
        else return true;
    }

    public static void removeActivePlayer(String account) {
        for (int i = 0; i < activePlayers.size(); i++) ;
        if (activePlayers.containsKey(account)) {activePlayers.remove(account);}
        else if (!activePlayers.containsKey(account)) {
            System.out.println("Could not find account in active player list.\n" +
                    "Here is the list of active players and their balances:\n ");
            showActivePlayers();
        }
    }


    public static void showActivePlayers(){
        System.out.println(activePlayers);
    }

    public static void playerSetup(int maxPlayers){
        while(true) {
            int numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers && numPlayers == activePlayers.size()) {
                break;
            } else if (numPlayers != activePlayers.size()) {
                System.out.println("The number of players you entered does not match the number\n" +
                        "of accounts that are logged in. Sending you back to the\n" +
                        "main menu to fix your number of logged in accounts.");
                Casino.mainMenu();
            } else System.out.println("That is not a valid number of players, " +
                        "please enter a number that is " + maxPlayers + " or less\n");
        }
    }
}


//    /**
//     * @param accountName     name of account to be returned
//     * @param accountPassword password of account to be returned
//     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
//     */
//    public CasinoAccount getAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
//    }
//
//    /**
//     * logs & creates a new `ArcadeAccount`
//     *
//     * @param accountName     name of account to be created
//     * @param accountPassword password of account to be created
//     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
//     */
//    public CasinoAccount createAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
//    }
//
//    /**
//     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
//     *
//     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
//     */
//    public void registerAccount(CasinoAccount casinoAccount) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
//    }