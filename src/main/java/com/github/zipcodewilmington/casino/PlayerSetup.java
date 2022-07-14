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
        for (Map.Entry<String, Account> pair : activePlayers.entrySet()){
            int i = 1;
            System.out.println(String.format("Player " + i + "is  %s", pair.getKey()));
            i++;
        }
    }

    public static void playerSetup(int maxPlayers) {
        int numPlayers;
        while (true) {
            numPlayers = TheScanner.getNumber("How many players are going to be playing in this game?\n");
            if (numPlayers >= 1 && numPlayers <= maxPlayers) {
                break;
            } else System.out.println("That is not a valid number of players.\n" +
                    "Please enter a number between 1 and " + maxPlayers + ".");
        }
        for (int i = 0 ; i <= numPlayers; i++) {
            Account.login();
        }

    }
}