package com.github.zipcodewilmington.casino.games.Roulette;

public abstract class BetAttempt {
    private String mySelection;//kind of bet
    private int odds;// matching amount to the bet
   public BetAttempt(String mySelection,int odds)
   {
       this.mySelection = mySelection;
      this.odds=odds;
   }

   public int pay(int wager)
   {
       return odds * wager;//pay for winning bet
   }

   public abstract void place();//allow user to select bet type

    public abstract boolean isWinning (SpinWheelResult spinResult);

}
