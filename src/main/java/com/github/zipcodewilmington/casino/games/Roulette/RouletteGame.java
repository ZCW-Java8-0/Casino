package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class RouletteGame implements GamblingGame<RoulettePlayer> {
//    private  Map<RoulettePlayer,Integer> bets;  //Map<playerType,howMuch>
//
//    private Map<RoulettePlayer, Integer>  betOddEven;  // betting number
//    private  int winningNumber;  //dealer announce number
   private int  maxPlayers;

  private SpinWheel myWheel=new SpinWheel();
    private static Scanner scan = new Scanner(System.in);
    @Override
    public void setBets () {
        //ask for betting money?
        //check for bet within available balance
        //ask for no which is odd/even
    }

    /**
     *
     * @param low
     * @param high
     * @return   --> random number  0 to 36
     */
      int random (int low, int high){
        return (int)  (Math.floor(Math.random() *(high-low+1)+low));
      }

    /**
     * Validate spinned number is Even/Odd
     */
    public  int rouletteSpinWheel(){   //determine spinned nUmber is  Odd/even
          int result=random(0,36); //10

          if(result %2==0){
              return result;
              //System.out.println("Winner is Even");
          }
          else {
              return result;
              //System.out.println("Winner is Odd");
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

        OddEven OddEven1 = new OddEven("Odd or Even", 1);
        System.out.println("Enter amount");
        int betAmount = scan.nextInt();
        OddEven1.place();
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
    public void setWinCondition () {

    }





    @Override
    public Player[] getWinner () {
        return new Player[0];
    }

    @Override
    public void exit () {

    }
}
