package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerSetup {
//    public static ArrayList<String> activePlayers = new ArrayList<>();
    static Map<String, Account> activePlayers = new HashMap<>();

    public static void addActivePlayer(String accountName, Account account){
        if (activePlayers.containsKey(accountName)){
            System.out.println("This player is already logged in, please choose another account.");
        }
        else {activePlayers.put(accountName, account);
            System.out.println("Added " + accountName + " as Player" + activePlayers.size());}
    }

    public static void removeActivePlayer(String accountName) {
        if (activePlayers.containsKey(accountName)){
            activePlayers.remove(accountName);
            System.out.println("Removed " + accountName + " from active player list.\n" +
                    "Remaining active players:\n");
            showActivePlayers();
        }
        else {System.out.println("That player is not currently logged in.");}
    }


    public static void showActivePlayers(){
        System.out.println(activePlayers.keySet());
    }

    public static void playerSetup(int maxPlayers){
        while(true) {
            int numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers) {
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