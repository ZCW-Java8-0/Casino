package com.github.zipcodewilmington.casino.games.ceelo;


import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class CeeLoGame implements GamblingGame<CeeLoPlayer> {

    private int maxPartySize;
    private Map<CeeLoPlayer, Integer> bets;
    static Random diceNumber = new Random();
    private Map<CeeLoPlayer, Integer[]> rollResult;
    public CeeLoGame(List<CeeLoPlayer> players) {
        for (CeeLoPlayer s : players) {
            this.bets.put(s,null);
            if(bets.size() > maxPartySize){
                System.out.println("The max amount of players is 2 people.");
                break;
            }
        }
    }

    @Override
    public void setBets() {

    }

    @Override
    public void distributeWinningsToWinners(CeeLoPlayer winner) {

    }

    @Override
    public void distributeWinningsToWinners() {

    }


    @Override
    public void play() {

    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 2;
    }

    @Override
    public void addPlayer(CeeLoPlayer player) {
    this.bets.put(player,0);
    }

    @Override
    public void removePlayer(CeeLoPlayer player) {
    this.bets.remove(player);
    }

    @Override
    public void winConditionCheck(CeeLoPlayer player) {

    }

    @Override
    public void setWinCondition() {

    }

    @Override
    public Player[] getWinner() {
        return new Player[0];
    }

    @Override
    public void exit() {

    }

    //    have all dice combinations resolve to a single number
//    Invalid rolls will result in 0 or re-roll
//    Rolls with dice1 and dice2 have same values and dice 3 has a different value, result = dice 3
//    Rolls with all three dice that are the same = 6 + the dice value.

    public int rollResults(CeeLoPlayer player){
        Integer[] diceArray = rollResult.get(player);
        Arrays.sort(diceArray);// just to read outcome better.
        int rollvalue = 0;
        for (int i=0; i < diceArray.length; i++) {
            if (diceArray[0] == 4 && diceArray[1] == 5 && diceArray[2] == 6) {
                return rollvalue = 13;
            }///automatic win break out of game pay winnings
            if (diceArray[0] == 1 && diceArray[1] == 2 && diceArray[2] == 3) {
                return 0;
            }///automatic lose break out of game lose bet.
            if (diceArray[0].equals(diceArray[1]) && diceArray[0].equals(diceArray[2])) {
                return rollvalue = diceArray[0] + 6;
            }
            if (diceArray[0].equals(diceArray[1])) {
                return rollvalue = diceArray[2];
            }
            if (diceArray[0].equals(diceArray[2])) {
                return rollvalue = diceArray[1];
            }
            if (diceArray[1] == diceArray[2]) {
                return rollvalue = diceArray[0];
            }

        }
        return rollvalue;
    }
    public int getWinner(CeeLoPlayer player1, CeeLoPlayer player2){

        int ceeLoPlayer1 = rollResults(player1);
        int ceeLoPlayer2 = rollResults(player2);

        if (ceeLoPlayer1 == ceeLoPlayer2) {
            System.out.println("It is a tie! Double bets and re-roll!");
            //re-roll and put through roll results again

        }else if (ceeLoPlayer1==13) {
            System.out.println("Player 1 got an automatic win!");
            // if either player gets 13, auto win and take money


        }else if (ceeLoPlayer1 > ceeLoPlayer2){

            System.out.println("Player 1 has won!");
        }else if (ceeLoPlayer2 > ceeLoPlayer1){

            System.out.println("Player 2 has won!");{}

        return 0;
    }



}
