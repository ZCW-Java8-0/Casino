package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.*;

public class BlackJack implements GamblingGame<BlackJackPlayer> {
    Scanner scanner = new Scanner(System.in);
    private Map<BlackJackPlayer, Integer> bets;
    private Map<BlackJackPlayer, Card[]> playerHand;
    private Map<BlackJackPlayer, Integer> playerHandSum;
    private Map<BlackJackPlayer, Boolean> winLose;
    private Map<BlackJackPlayer, Boolean> blackJackFlag;
    private int dealerHandSum;
    private Card[] dealerHand;
    private int maxPartySize;

    @Override
    public void play() {
    }

    public BlackJack(List<BlackJackPlayer> players) {
        for (BlackJackPlayer s: players){
            this.bets.put(s,null);
            this.playerHand.put(s,null);
            if (bets.size()>maxPartySize){
                System.out.println("Only 4 players are allowed to play!");
                break;
            }
        }
    }

    private int[] CardValue(Card card){
        int[] value = new int[0];
        CardFace cardFace = card.getCardFace();
        switch (cardFace){
            case Ace: value= new int[]{1, 11}; break;
            case Two: value= new int[]{2}; break;
            case Three: value= new int[]{3}; break;
            case Four: value= new int[]{4}; break;
            case Five: value= new int[]{5}; break;
            case Six: value= new int[]{6}; break;
            case Seven: value= new int[]{7}; break;
            case Eight: value= new int[]{8}; break;
            case Nine: value= new int[]{9}; break;
            case Ten:
            case Jack:
            case Queen:
            case King: value= new int[]{10}; break;
        }
        return value;
    }

    public void blackJackCheck(BlackJackPlayer blackJackPlayer){
        Card[] tempPlayerHand = playerHand.get(blackJackPlayer);
        if (tempPlayerHand.length != 2) {
            blackJackFlag.put(blackJackPlayer, false);
        }
        else if (this.CardValue(tempPlayerHand[0])[0]==10)
        {
            if (tempPlayerHand[1].getCardFace().equals(CardFace.Ace)) {
                blackJackFlag.put(blackJackPlayer, true);
            }
            else
                blackJackFlag.put(blackJackPlayer, false);
        }
        else if (this.CardValue(tempPlayerHand[1])[0]==10) {
            if (tempPlayerHand[0].getCardFace().equals(CardFace.Ace)) {
                blackJackFlag.put(blackJackPlayer, true);
            }
            else
                blackJackFlag.put(blackJackPlayer, false);
        }
    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 4;
    }

    @Override
    public void addPlayer(BlackJackPlayer player) {
        this.bets.put(player,0);
    }

    @Override
    public void removePlayer(BlackJackPlayer player) {
        this.bets.remove(player);
    }


    @Override
    public void winConditionCheck(BlackJackPlayer blackJackPlayer) {
        int playerSum = playerHandSum.get(blackJackPlayer);
        if (blackJackFlag.get(blackJackPlayer)==true)
            this.winLose.put(blackJackPlayer, true);
        else if (playerSum>dealerHandSum && playerSum <= 21)
            this.winLose.put(blackJackPlayer, true);
        else
            this.winLose.put(blackJackPlayer,false);
    }

    @Override
    public BlackJackPlayer[] getWinner() {
        List<BlackJackPlayer> winner = new ArrayList<>();
        for (BlackJackPlayer s : winLose.keySet()){
            if (winLose.get(s)==true)
                winner.add(s);
        }
        return winner.toArray(new BlackJackPlayer[winner.size()]);
    }

    @Override
    public void exit() {
    }

    @Override
    public void setBets() {
        Integer bet = 0, walletBalance;
        for (BlackJackPlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            try {
                System.out.println("Hello" +s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet=scanner.nextInt();
                if (bet<walletBalance){
                    System.out.println("Bet exceeds what you have, try again");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Not a number, try again");
                continue;
            }
            bets.put(s, bet);
            s.applyBet(bet);
        }
    }

    @Override
    public void distributeWinningsToWinners(BlackJackPlayer[] winner) {
        for (BlackJackPlayer s: winner) {
            s.addWinning(bets.get(s)*2);
        }
    }
}
