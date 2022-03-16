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

    public CeeLoGame(List<CeeLoPlayer> players) {
        for (CeeLoPlayer s : players) {
            this.bets.put(s,null);
            if(bets.size() > maxPartySize){
                System.out.println("The max amount of players is 4 people.");
                break;
            }
        }
    }

    @Override
    public void setBets() {

    }

    @Override
    public void distributeWinningsToWinners() {

    }


    @Override
    public void play() {

    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 4;
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

    public static int rollConditions(int[] ints){
        boolean validRoll = true;
        Random diceNumber = new Random();
        int[] diceArray = Dice.rollDice(diceNumber);


        Arrays.sort(diceArray);// just to read outcome better.
        if (diceArray[0] == 4 && diceArray[1] == 5 && diceArray[0] == 6) {return 13;}///automatic win break out of game pay winnings
        if (diceArray[0] == 1 && diceArray[1] == 2 && diceArray[0] == 3) {return 0;}///automatic lose break out of game lose bet.
        if (diceArray[0] == diceArray[1]) {return diceArray[2];}
        if (diceArray[0] == diceArray[2]) {return diceArray[1];}
        if (diceArray[1] == diceArray[2]) {return diceArray[0];}
        if (diceArray[0] == diceArray[1] && diceArray[1] == diceArray[2]) {return diceArray[1] + 6;}
        return 0;
    }
    public static int getWinner (int[]ceeLoPlayer1Roll,int[]ceeLoPlayer2Roll,int[]ceeLoPlayer3Roll,int[]ceeLoPlayer4Roll ){
        Random diceNumber = new Random();
        int ceeLoplayer1 = rollConditions(Dice.rollDice(diceNumber));
        return 0;
    }


}
