package com.github.zipcodewilmington.casino.blackjack;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;



public class BlackJackGame {
    int playerAmount = 0;
    int dealerAmount = 0;

    int playerChips = 500;

    int playerBet = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Bobby's Brutal Blackjack. Name's Bobby, nice to meet cha.");
        BlackJackGame bj = new BlackJackGame();
        bj.playGame();
    }


    void playGame() {
        getDealerAmount();
        welcomeStatement();
        getPlayerBet();
        dealerRecap();

        while (playerAmount < 21 && playerAmount <= dealerAmount){
            Scanner scan = new Scanner(System.in);
            if ((playerBet * 2) < playerChips);
            System.out.println("Kiddo, type 'dd' to double down, or hit enter to draw");
            String respond = scan.nextLine();
            System.out.println(respond);
            if (respond == "dd"){
                doubleDown();
            }else{
                playerDraw();
            }

        }

        if (playerAmount <= 21 && playerAmount > dealerAmount){
            playerWins(playerChips, playerBet);
        } else if (playerAmount > 21){
            dealerWins(playerChips, playerBet);
        }

    }



    private void welcomeStatement(){
        System.out.println("Let's jack it up!\n");
    }

    public int getDealerAmount(){
        Random random = new Random();
        int min = 17;
        int max = 3;
        int dealerNum = min + random.nextInt(max);
        dealerAmount = dealerNum;
        return dealerAmount;
    }

    public void dealerRecap() {
        System.out.println("It looks like the dealer has pulled a " + dealerAmount + ". See if you can beat that.");
    }

    public int playerDraw() {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int min = 1;
        System.out.println("OK kid, you got " + playerAmount + ". Draw a card and see if you can win.");
        System.out.println("Hit enter to draw");
        scan.nextLine();
//        int nextDraw = min + random.nextInt(9);
        int nextDraw = 11;
        if (nextDraw == 1 || nextDraw == 11){
            aces();
            } else{
            playerAmount += nextDraw;
            System.out.println("Ya drew a " + nextDraw + "!");
        }
        return playerAmount;
    }


    public void aces() {
        int nextDraw = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose if you want this Ace to be a 1 or an 11.");
//        try {int nextDraw = scan.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("That ain't a number I ever heard of.");
//            aces();}
        try {nextDraw = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That ain't a number I ever heard of.");
            aces();

        }
            if (nextDraw == 1 || nextDraw == 11) {
                playerAmount += nextDraw;
                System.out.println("Ya drew a " + nextDraw + "!");
            }else{
                System.out.println("Nice try.");
                aces();
            }

        }



    public void playerWins(int playerChips, int playerBet){
        Scanner scan = new Scanner(System.in);
        playerChips += playerBet;
        System.out.println("Wowzers, you got " + playerAmount + " and won " + playerBet + " chips! You now have " + playerChips + " chips!");
        playerAmount = 0;
        scan.nextLine();
        playGame();
    }

    public void dealerWins(int playerChips, int playerBet){
        Scanner scan = new Scanner(System.in);
        playerChips-=playerBet;
        System.out.println(playerAmount + "! Welp, them's the breaks, kid. You lost " + playerBet + " chips and now have " + playerChips + " chips.");
        playerAmount = 0;
        scan.nextLine();
        playGame();
    }

    public void doubleDown(){
        playerBet = playerBet * 2;
        System.out.println("OK kid, this next one is for all da marbles! Let's see what cha got!");
        playerDraw();
        if (playerAmount <= 21 && playerAmount > dealerAmount){
            playerWins(playerChips, playerBet);
        } else{
            dealerWins(playerChips, playerBet);
        }
    }


    public int getPlayerBet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'? Bet 0 if ya want!");
        try {
        playerBet = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That ain't a number I ever heard of.");
            getPlayerBet();

        }
        if (playerBet > playerChips){
            System.out.println("Kid, that bet is too big for your britches. Try a smaller amount.");
            getPlayerBet();
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
            getPlayerBet();
        }
        return playerBet;
        }




    }

//    int getNumb(String message) {
//
//    Scanner scan = new Scanner(System.in);
//        while (true) {
//            System.out.print(message);
//            try {
//                return scan.nextInt();
//            }
//            catch (InputMismatchException e) {
//                System.out.println("\"" + scan.next() + "\" isn't a number!");


