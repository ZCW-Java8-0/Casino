package com.github.zipcodewilmington.casino;


import com.github.zipcodewilmington.utils.TheScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Account {

    //INITIALIZING VARIABLES
    private String accountName;
    private String name;
    private String password;
    private int balance;
//    static List<Account> allAccounts = new ArrayList<>();
    static Map<String, Account> allAccounts = new HashMap<>();


    //CONSTRUCTORS
    public Account() {
        this.accountName = "";
        this.name = "";
        this.password = "";
        this.balance = 0;
        allAccounts.put(accountName, this);
    }
    public Account(String acctName, String name, String password, int balance){
        this.accountName = acctName;
        this.name = name;
        this.password = password;
        this.balance = balance;
        allAccounts.put(accountName, this);
    }

    //SETTERS
    public void setAccountName(String acctName){this.accountName = acctName;}
    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
    public void setBalance(int balance){this.balance = balance;}

    //GETTERS
    public String getAccountName(){return this.accountName;}
    public String getName(){return this.name;}
    public String getPassword(){return this.password;}
    public Integer getBalance(){return this.balance;}

    //METHODS

    public int makeBet(Account account){
        int amount;
        while(true) {
           amount = TheScanner.getNumber("How much do you want to bet?");
            if (allAccounts.containsKey(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsKey(account) && account.balance < amount) {
                System.out.println("You don't have that much in your account.\n" +
                        "Current account balance is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
        return amount;
    }


    public void deposit(Account account, int amount){
        account.balance += amount;
    }


    public static boolean checkForDupes(String name){
        //false means there are dupes, true means there are not
        for (int i = 0 ; i < allAccounts.size() ; i++) {
            if (name.equals(allAccounts.get(i))) return false;
        }
        return true;
    }
}