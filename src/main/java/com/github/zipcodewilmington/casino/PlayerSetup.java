package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerSetup {
    public static ArrayList<Account> activePlayers = new ArrayList<>();
//    static Map<String, Account> activePlayers = new HashMap<>();

    public static void addActivePlayer(Account account){
        if (activePlayers.contains(account)){
            System.out.println("This player is already logged in, please choose another account.");
        }
        else {activePlayers.add(account);
            System.out.println("Added " + account.getAccountName() + " as Player" + activePlayers.size());}
    }

    public static void removeActivePlayer(Account account) {
        if (activePlayers.contains(account)){
            activePlayers.remove(account);
            System.out.println("Removed " + account + " from active player list.\n" +
                    "Remaining active players:\n");
            showActivePlayers();
        }
        else {System.out.println("That player is not currently logged in.");}
    }

    public static void showActivePlayers(){
        for (int i = 0 ; i < activePlayers.size() ; i++) {
            System.out.println("Player " + (i+1) + ": " + activePlayers.get(i).getAccountName());
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
        for (int i = 0 ; i < numPlayers; i++) {
            Account.login();
        }
    }
}