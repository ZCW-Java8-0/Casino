package com.github.zipcodewilmington.casino.games.Roulette;
import java.util.Scanner;

public class OddEven extends BetAttempt{
    private String myBetChoice;
    private static Scanner scan = new Scanner(System.in);
    public OddEven ( String mySelection, int odds) {
        super(mySelection, odds);
        myBetChoice = "";
    }

    public void place()
    {
        System.out.println("Select your bet: Even or Odd");
        myBetChoice = scan.next();//even or odd input from player
    }

    public boolean isWinning (SpinWheelResult wheel)
    {
        return (wheel.getNumber()%2 == 0 && myBetChoice.equals("even")) ||
                (wheel.getNumber()%2 == 1 && myBetChoice.equals(("odd")));
    }
}
