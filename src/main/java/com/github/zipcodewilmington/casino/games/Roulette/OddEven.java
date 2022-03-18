package com.github.zipcodewilmington.casino.games.Roulette;
import java.util.*;

public class OddEven extends BetAttempt{
  //  private String myBetChoice;
  private Map<RoulettePlayer, Integer> bets = new HashMap<>();
    private Map<RoulettePlayer, String> myBetChoice = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);
    public OddEven ( String mySelection, int odds, List<RoulettePlayer> players) {
        super(mySelection, odds);
        //myBetChoice = "";
        for ( RoulettePlayer s: players){
            this.myBetChoice.put(s,null);

        }

    }

    public void place()
    {
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
        String betchoice;
        //set player choice
        for (RoulettePlayer s: myBetChoice.keySet()){

            try {
                System.out.println("Hello" +s.getPerson().getName() + ", what is your bet choice?odd or even?");
                System.out.println();
                betchoice=scan.next();
                if (betchoice.equals("odd") || betchoice.equals("even")){
                    System.out.println("choice entered");

                }
            } catch (InputMismatchException e){
                System.out.println("Not a correct choice, try again");
                continue;
            }
            myBetChoice.put(s,betchoice);
        }
    }

    public boolean isWinning (SpinWheelResult wheel)
    {
        return (wheel.getNumber()%2 == 0 && myBetChoice.equals("even")) ||
                (wheel.getNumber()%2 == 1 && myBetChoice.equals(("odd")));
    }
}
