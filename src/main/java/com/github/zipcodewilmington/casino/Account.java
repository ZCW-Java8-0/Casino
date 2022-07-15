package com.github.zipcodewilmington.casino;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.*;

import static com.github.zipcodewilmington.casino.PlayerSetup.activePlayers;

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
    public static void login(){
        Account tempAccount;
        Scanner scan = new Scanner(System.in);
        String acctName;
        String pw;
        while(true) {
            System.out.println("Please enter your account name, or type \"exit\" to return to main menu.\n");
            acctName = scan.nextLine();
            tempAccount = allAccounts.get(acctName);
            if (accountExists(acctName) && !activePlayers.contains(tempAccount)) {
                break;
            } else if (accountExists(acctName) && activePlayers.contains(tempAccount)) {
                System.out.println("That account is already logged in, please log into a different account.\n");
            } else if (acctName.equals("exit")) {
                Casino.splashScreen();
            } else if (!accountExists(acctName)) {
                System.out.println("There is no record of an account with that name, please re-enter\n" +
                        "your account name, or return to the main menu and create an account.\n");
            }
        }
        while(true) {
            System.out.println("Please enter your password.\n");
            pw = scan.nextLine();
            if (tempAccount.getPassword().equals(pw)) {
                System.out.println("Password accepted.\n");
                break;
            } else System.out.println("Password does not match account " + acctName + ".\n");
        }
        activePlayers.add(tempAccount);
    }

    public static int makeBet(Account account){
        int amount;
        while(true) {
           amount = TheScanner.getNumber("How much do you want to bet?");
            if (allAccounts.containsValue(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsValue(account) && account.balance < amount) {
                System.out.println("You don't have that much in your account.\n" +
                        "Current account balance is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
        return amount;
    }


    public static void deposit(Account account, int amount){
        account.balance += amount;
    }

    public static boolean accountExists(String acctName){
            if (allAccounts.containsKey(acctName)) {
                return true;
            } else return false;
        }

    public static void loginTest(){
        Account tempAccount;
        Scanner scan = new Scanner(System.in);
        String acctName;
        String pw;
        while(true) {
            System.out.println("Please enter your account name, or type \"exit\" to return to main menu.\n");
            acctName = "test";
            tempAccount = allAccounts.get(acctName);
            if (accountExists(acctName) && !activePlayers.contains(tempAccount)) {
                break;
            } else if (accountExists(acctName) && activePlayers.contains(tempAccount)) {
                System.out.println("That account is already logged in, please log into a different account.\n");
            } else if (acctName.equals("exit")) {
                Casino.splashScreen();
            } else if (!accountExists(acctName)) {
                System.out.println("There is no record of an account with that name, please re-enter\n" +
                        "your account name, or return to the main menu and create an account.\n");
            }
        }
        while(true) {
            System.out.println("Please enter your password.\n");
            pw = "test";
            if (tempAccount.getPassword().equals(pw)) {
                System.out.println("Password accepted.\n");
                break;
            } else System.out.println("Password does not match account " + acctName + ".\n");
        }
        activePlayers.add(tempAccount);
    }
    public static int makeBetTest(Account account, int amount){
        while(true) {
            if (allAccounts.containsValue(account) && account.balance >= amount) {
                account.balance -= amount;
                break;
            } else if (allAccounts.containsValue(account) && account.balance < amount) {
                System.out.println("You don't have that much in your account.\n" +
                        "Current account balance is: " + account.getBalance() + "Please enter a valid amount.\n");
            }
        }
        return account.getBalance();
    }
}