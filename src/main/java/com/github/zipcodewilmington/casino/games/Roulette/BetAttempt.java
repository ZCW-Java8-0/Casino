package com.github.zipcodewilmington.casino.games.Roulette;

public abstract class BetAttempt {
    private String mySelection;//kind of bet
    private int myBet;// betting amount
   public BetAttempt(String mySelection,int myBet)
   {
       this.mySelection = mySelection;
      this.myBet=myBet;
   }

   public int pay(int wager)
   {
       return myBet * wager;//pay for winning bet
   }

   public abstract void place();//allow user to select bet type

    public abstract boolean isWinning (SpinWheelResult spinResult);

}
