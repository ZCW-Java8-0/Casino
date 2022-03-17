package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public class RouletteGame implements GamblingGame<RoulettePlayer> {
    private  Map<RoulettePlayer,Integer> bets;  //Map<playerType,howMuch>
    private Map<RoulettePlayer, Integer>  betOddEven;  // betting number
    private  int winningNumber;  //dealer announce number
   private int  maxPlayers;

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
    public void distributeWinningsToWinners () {


    }

    @Override
    public Map<Player, Boolean> winCondition () {
        return null;
    }

    @Override
    public void play () {

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
