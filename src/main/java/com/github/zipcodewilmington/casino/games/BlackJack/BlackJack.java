package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.List;
import java.util.Map;

public class BlackJack implements GamblingGame<BlackJackPlayer> {
    private Map<BlackJackPlayer, Integer> bets;
    private Map<BlackJackPlayer, Card[]> playerHand;
    private Map<BlackJackPlayer, Integer> playerHandSum;
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
    public Map<BlackJackPlayer, Boolean> setWinCondition() {
        return null;
    }

    @Override
    public Player[] getWinner() {
        return new Player[0];
    }

    @Override
    public void exit() {
    }

    @Override
    public void setBets() {
    }

    @Override
    public void distributeWinningsToWinners() {
    }
}
