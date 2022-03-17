package com.github.zipcodewilmington.casino.games.ceelo;




import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;


import java.util.*;


public class CeeLoGame implements GamblingGame<CeeLoPlayer> {
    Scanner scanner = new Scanner(System.in);
    Random diceNumber = new Random();
    private Map<CeeLoPlayer, Integer> bets = new HashMap<>();
    private int maxPartySize;

    private Map<CeeLoPlayer, Integer[]> rollResult;
    private Map<CeeLoPlayer, Boolean> tieFlag= new HashMap<>();


    public CeeLoGame(List<CeeLoPlayer> players) {
        for (CeeLoPlayer s : players) {
            this.bets.put(s, null);
            if (bets.size() > maxPartySize) {
                System.out.println("The max amount of players is 2 people.");
                break;
            }
        }
    }

    @Override
    public void setBets() {
        Integer bet = 0, walletBalance;
        for (CeeLoPlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            try{
                System.out.println("Hello " + s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet = scanner.nextInt();
                if (bet>walletBalance){
                    System.out.println("Bet exceeds wallet balance, try again.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Not a number, try again.");
                continue;
            }
            bets.put(s, bet);
            s.applyBet(bet);
        }
    }

    @Override
    public void distributeWinningsToWinners(CeeLoPlayer winner) {winner.addWinning(bets.get(winner));}


    @Override
    public void play() {
    String input;
    Map<CeeLoPlayer, Boolean> tieFlag = null;

    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 2;
    }

    @Override
    public void addPlayer(CeeLoPlayer player) {
        this.bets.put(player, 0);
    }

    @Override
    public void removePlayer(CeeLoPlayer player) {
        this.bets.remove(player);
    }

    @Override
    public void winConditionCheck(CeeLoPlayer player) {

    }

    @Override
    public void exit() {

    }

    //    have all dice combinations resolve to a single number
//    Invalid rolls will result in 0 or re-roll
//    Rolls with dice1 and dice2 have same values and dice 3 has a different value, result = dice 3
//    Rolls with all three dice that are the same = 6 + the dice value.

    public int rollResults(CeeLoPlayer player) {
        Integer[] diceArray = rollResult.get(player);
        Arrays.sort(diceArray);// just to read outcome better.
        int rollValue = 0;
        for (int i = 0; i < diceArray.length; i++) {
            if (diceArray[0] == 4 && diceArray[1] == 5 && diceArray[2] == 6) {
                return rollValue = 13;
            }///automatic win break out of game pay winnings
            if (diceArray[0] == 1 && diceArray[1] == 2 && diceArray[2] == 3) {
                return 0;
            }///automatic lose break out of game lose bet.
            if (diceArray[0].equals(diceArray[1]) && diceArray[0].equals(diceArray[2])) {
                return rollValue = diceArray[0] + 6;
            }
            if (diceArray[0].equals(diceArray[1])) {
                return rollValue = diceArray[2];
            }
            if (diceArray[0].equals(diceArray[2])) {
                return rollValue = diceArray[1];
            }
            if (diceArray[1] == diceArray[2]) {
                return rollValue = diceArray[0];
            }

        }
        return rollValue;
    }

    public int getWinner(CeeLoPlayer player1, CeeLoPlayer player2) {

        int ceeLoPlayer1 = rollResults(player1);
        int ceeLoPlayer2 = rollResults(player2);

        if (ceeLoPlayer1 == ceeLoPlayer2) {
            System.out.println("It is a tie! Double bets and re-roll!");
            //re-roll and put through roll results again

        } else if (ceeLoPlayer1 == 13) {
            System.out.println("Player 1 rolled a 4, 5, 6! It's an automatic win!");
            // if either player gets 13, auto win and take money

        } else if (ceeLoPlayer2 == 13) {
            System.out.println("Player 2 rolled a 4, 5 6! It's an automatic win!");

        } else if (ceeLoPlayer1 == 0) {
            System.out.println("Player 1 rolled a 1, 2, 3! It's an automatic lose!");

        } else if (ceeLoPlayer2 == 0) {
            System.out.println("Player 2 rolled a 1, 2, 3! It's an automatic lose");

        } else if (ceeLoPlayer1 > ceeLoPlayer2) {
            System.out.println("Player 1 has won! with a " + ceeLoPlayer1);

        } else if (ceeLoPlayer2 > ceeLoPlayer1) {
            System.out.println("Player 2 has won! with a " + ceeLoPlayer2);
            {
            }


        }

        return 0;
    }
}
