package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.*;

public class RouletteGame implements GamblingGame<RoulettePlayer> {
//    private  Map<RoulettePlayer,Integer> bets;  //Map<playerType,howMuch>
//
//    private Map<RoulettePlayer, Integer>  betOddEven;  // betting number
//    private  int winningNumber;  //dealer announce number
   private int  maxPlayers;
    private Map<RoulettePlayer, Integer> bets = new HashMap<>();
  private SpinWheel myWheel=new SpinWheel();
    private static Scanner scan = new Scanner(System.in);
    @Override
    public void setBets () {
        //ask for betting money?
        //check for bet within available balance
        //ask for no which is odd/even
        Integer bet = 0, walletBalance;
        for (RoulettePlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            try {
                System.out.println("Hello" +s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet=scan.nextInt();
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
    public void distributeWinningsToWinners (RoulettePlayer winner) {

        System.out.println("distribute");
    }

    @Override
    public Map<Player, Boolean> winCondition () {
        return null;
    }

    @Override
    public void play () {

        OddEven OddEven1 = new OddEven("Odd or Even", 2);
        //odd/even:2, red/black:2 dozen:5 ind slots:35
        System.out.println("Enter amount");
        int betAmount = scan.nextInt();
        OddEven1.place();// ask player for Odd or Even?
        System.out.println("Spinning...");

        SpinWheelResult spinwheelResult = myWheel.spin();

        System.out.println(String.format("Dropped into %s",spinwheelResult));

        if(OddEven1.isWinning(spinwheelResult))
        {
            System.out.println("****Congratulations : you win***");
            OddEven1.pay(betAmount);
        }
        else
        {
            System.out.println("***Sorry: you lose ****");

        }

    }


    public RouletteGame(List<RoulettePlayer> players) {
        for ( RoulettePlayer s: players){
            this.bets.put(s,null);
           // this.playerHand.put(s,null);
            if (bets.size()>this.maxPlayers){
                System.out.println("Only 4 players are allowed to play!");
                break;
            }
        }

    }

    @Override
    public void setPlayerMax () {
        this.maxPlayers =4;

    }

    @Override
    public void addPlayer ( RoulettePlayer player ) {

    }

    @Override
    public void removePlayer ( RoulettePlayer player ) {

    }

    @Override
    public void winConditionCheck ( RoulettePlayer player ) {

    }


    //@Override
    public void setWinCondition () {

    }





   // @Override
    public Player[] getWinner () {
        return new Player[0];
    }

    @Override
    public void exit () {

    }
}
