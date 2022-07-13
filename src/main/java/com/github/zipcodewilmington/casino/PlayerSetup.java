package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerSetup {
    public static ArrayList<String> activePlayers = new ArrayList<>();


    public static void addActivePlayer(String account){
        if (activePlayers.contains(account)){
            System.out.println("This player is already logged in, please choose another account.");
        }
        else {activePlayers.add(account);
            System.out.println("Added " + account + " as Player" + activePlayers.size());}
    }

    public static void removeActivePlayer(String account) {
        if (activePlayers.contains(account)){
            for (int i = 0 ; i < activePlayers.size() ; i++) {
                if (activePlayers.get(i).equals(account)){
                    activePlayers.remove(i);
                    break;}
            }
            System.out.println("Removed " + account + " from active player list.\n" +
                    "Remaining active players:\n");
            showActivePlayers();
        }
        else {System.out.println("That player is not currently active.");}
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