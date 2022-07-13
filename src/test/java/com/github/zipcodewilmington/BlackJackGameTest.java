package com.github.zipcodewilmington;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class BlackJackGameTest {
    @Test
    public void getPlayerBetGood(){
        int playerChips = 50;
        int bet = 45;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'? Bet 0 if ya want!");
        int playerBet = bet;
        if (playerBet > playerChips){
            System.out.println("Kid, that bet is too big for your britches. Try a smaller amount.");
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
        }
assert (playerBet == bet);

    }


    @Test
    public void getPlayerBetOver(){
        int playerChips = 50;
        int bet = 55;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'? Bet 0 if ya want!");
        int playerBet = bet;
        if (playerBet > playerChips){
            System.out.println("Kid, that bet is too big for your britches. Try a smaller amount.");
            playerBet = 0;
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
            playerBet = 25;
        }
        assert (playerBet == 0);

    }

    @Test
    public void getPlayerBetunder0(){
        int playerChips = 50;
        int bet = -27;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chips are ya bettin'? Bet 0 if ya want!");
        int playerBet = bet;
        if (playerBet > playerChips){
            System.out.println("Kid, that bet is too big for your britches. Try a smaller amount.");
            playerBet = 25;
        }else if (playerBet < 0) {
            System.out.println("Hey, don't try it with the funny business!");
            playerBet = 0;
        }
        assert (playerBet == 0);

    }

}