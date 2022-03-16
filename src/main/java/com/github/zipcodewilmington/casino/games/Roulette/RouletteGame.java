package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public class RouletteGame implements GamblingGame {
    @Override
    public void setBets () {
        //ask for betting money?
        //check for bet within avaialble balance
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
    public  void spinWheel(){
          int result=random(0,36);
          if(result %2==0){
              System.out.println("Winner is Even");
          }
          else {
              System.out.println("Winner is Odd");
          }
      }

    @Override
    public void distributeWinningsToWinners () {

    }

    @Override
    public void play () {

    }

    @Override
    public void setPlayerMax () {

    }

    @Override
    public void addPlayer ( Player player ) {

    }

    @Override
    public void removePlayer ( Player player ) {

    }

    @Override
    public Map<Player, Boolean> winCondition () {
        return null;
    }

    @Override
    public Player[] getWinner () {
        return new Player[0];
    }

    @Override
    public void exit () {

    }
}
