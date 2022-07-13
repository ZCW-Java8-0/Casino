package com.github.zipcodewilmington.casino;


import java.util.ArrayList;
import java.util.List;

public class Account {

    //INITIALIZING VARIABLES
    private String accountName;
    private String name;
    private String password;
    private int balance;
    static List<Account> allAccounts = new ArrayList<>();



    //CONSTRUCTORS
    public Account() {
        this.accountName = "";
        this.name = "";
        this.password = "";
        this.balance = 2000;
        allAccounts.add(this);
    }
    public Account(String acctName, String name, String password, int balance){
        this.accountName = acctName;
        this.name = name;
        this.password = password;
        this.balance = balance;
        allAccounts.add(this);
    }

    //SETTERS
    public void setAccountName(String acctName){this.accountName = acctName;}
    public void setName(String name){this.name = name;}

    public void setAccountPassword(String password){this.password = password;}
    public void setAccountBalance(int balance){this.balance = balance;}

    //GETTERS
    public String getAccountName(){return this.accountName;}
    public String getName(){return this.name;}
    public String getpassword(){return this.password;}
    public Integer getbalance(){return this.balance;}

    //METHODS

    public void withdraw(int amount){
        if (amount > this.balance){System.out.println("You don't have that much!");}
        else this.balance -= amount;
    }
    public void deposit(int amount){
        this.balance += amount;
    }

    public static void createAccount(String name){
        Account account = new Account();
    }

    public static boolean checkForDupes(String name){
        //false means there are dupes, true means there are not
        for (int i = 0 ; i < allAccounts.size() ; i++) {
            if (name.equals(allAccounts.get(i))) return false;
        }
        return true;
    }
}


//    store everything in hashmap
//    make method to check number of players matches the number of players in hashmap