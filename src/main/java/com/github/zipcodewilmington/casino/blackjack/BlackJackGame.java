package com.github.zipcodewilmington.casino.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;



public class BlackJackGame {
    int playerHand = 0;
    int dealerHand = 0;

    int playerChips = 500;

    int playerBet = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Bobby's Brutal Blackjack. Name's Bobby, nice to meet cha.");
        BlackJackGame bj = new BlackJackGame();
        bj.playGame();
    }


    void playGame() {
Scanner scan = new Scanner(System.in);

        welcomeStatement();
        showPlayerBet();
        showDealerHand1();
        dealerRecap1();
        playerRecap();
        scan.nextLine();
        showPlayerDraw();
        showDealerHand2();
        dealerRecap2();
        while (playerHand < 21 && playerHand <= dealerHand) {
            if ((playerChips - playerBet) > playerBet) {
                System.out.println("Right now you got " + playerHand + ". Type 'dd' to double down, or hit enter to draw");
                String respond = scan.nextLine();
                if (respond.equals("dd")) {
                    doubleDown();
                } else {
                    showPlayerDraw();
                }
            }else{
                playerRecap();
                scan.nextLine();
                showPlayerDraw();
            }
        }

        if (playerHand <= 21 && playerHand > dealerHand){
            playerWins();
        } else if (playerHand > 21){
            dealerWins();
        }

    }



    private void welcomeStatement(){
        System.out.println("Let's jack it up!\n");
    }

    private int showDealerHand1(){
        dealerHand = 10;
       return dealerHand;
    }

    private int showDealerHand2(){
        Random random = new Random();
        int min = 6;
        int max = 4;
        dealerHand += min + random.nextInt(max);
        return dealerHand;
    }

    public void dealerRecap1() {
        System.out.println("It looks like the dealer has pulled a " + dealerHand + ".");
    }
    public void dealerRecap2() {
        System.out.println("It looks like the dealer has pulled a " + dealerHand + ". See if you can beat that.");
    }

    public void playerRecap(){
        System.out.println("Right now you got " + playerHand + ". Hit enter to draw");
    }

    private int showPlayerBet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'?");
        try {
            playerBet = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That ain't a number I ever heard of.");
            showPlayerBet();
        }
        if (playerBet > playerChips){
            System.out.println("That bet is too big for your britches. Try a smaller amount.");
            showPlayerBet();
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
            showPlayerBet();
        }
        return playerBet;
    }


    private int showPlayerDraw() {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int min = 1;
        int nextDraw = min + random.nextInt(9);
        if (nextDraw == 1 || nextDraw == 11){
            aces();
            } else{
            playerHand += nextDraw;
            System.out.println("Ya drew a " + nextDraw + "!");
        }
        return playerHand;
    }


    private int aces() {
        int nextDraw = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ooh, an Ace! Choose if you want this Ace to be a 1 or an 11.");
        try {nextDraw = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That ain't a number I ever heard of.");
            aces();
        }
            if (nextDraw == 1 || nextDraw == 11) {
                playerHand += nextDraw;
                System.out.println("Ya drew a " + nextDraw + "!");
            }else{
                System.out.println("Nice try.");
                aces();
            }
            return playerHand;
        }



    public void playerWins(){
        Scanner scan = new Scanner(System.in);
        playerChips += playerBet;
        System.out.println("Woah! You got " + playerHand + " and won " + playerBet + " chips! You now have " + playerChips + " chips! Hit enter to try again.");
        playerHand = 0;
        scan.nextLine();
        playGame();
    }

    public void dealerWins(){
        Scanner scan = new Scanner(System.in);
        playerChips-=playerBet;
        System.out.println(playerHand + "! Welp, them's the breaks, kid. You lost " + playerBet + " chips and now have " + playerChips + " chips. Hit enter to play again.");
        playerHand = 0;
        scan.nextLine();
        playGame();
    }

    public void doubleDown(){
        playerBet = playerBet * 2;
        System.out.println("OK kid, this next one is for all da marbles! Let's see what cha got!");
        showPlayerDraw();
        if (playerHand <= 21 && playerHand > dealerHand){
            playerWins();
        } else{
            dealerWins();
        }
    }

    }


