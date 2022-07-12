package com.github.zipcodewilmington.casino.games.blackjack;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;



public class BlackjackGame {
int playerAmount = 0;
int dealerAmount = 0;

int playerChips = 5;

int playerBet = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Bobby's Brutal Blackjack. Name's Bobby, nice to meet cha.");
        BlackjackGame bj = new BlackjackGame();
        bj.playGame();
    }


void playGame() {
    getDealerAmount();
    welcomeStatement();
    getPlayerBet();
    dealerRecap();

while (playerAmount < 21 && playerAmount <= dealerAmount){
    playerDraw();

}

if (playerAmount <= 21 && playerAmount > dealerAmount){
  playerWins();
} else if (playerAmount > 21){
    dealerWins();
}

}



private void welcomeStatement(){
    System.out.println("Let's jack it up!.\n");
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
        int nextDraw = min + random.nextInt(9);
        playerAmount += nextDraw;
        return playerAmount;


    }

    public void playerWins(){
            Scanner scan = new Scanner(System.in);
            playerChips += playerBet;
            System.out.println("Wowzers, you got " + playerAmount + " and won " + playerBet + " chips! You now have " + playerChips + " chips!");
            playerAmount = 0;
            scan.nextLine();
            playGame();
    }

    public void dealerWins(){
        Scanner scan = new Scanner(System.in);
        playerChips-=playerBet;
        System.out.println(playerAmount + "! Welp, them's the breaks, kid. You lost " + playerBet + " chips and now have " + playerChips + " chips.");
        playerAmount = 0;
        scan.nextLine();
        playGame();
    }



    public int getPlayerBet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'? 0 is also an option.");
        playerBet = scan.nextInt();
        if (playerBet > playerChips){
            System.out.println("Kid, that bet is too big for your britches. Try a smaller amount.");
            getPlayerBet();
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
            getPlayerBet();
        }
        return playerBet;
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

    }

