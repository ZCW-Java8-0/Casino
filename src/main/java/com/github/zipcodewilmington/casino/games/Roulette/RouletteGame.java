package com.github.zipcodewilmington.casino.games.Roulette;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

public class RouletteGame implements GamblingGame<RoulettePlayer> {
//    private  Map<RoulettePlayer,Integer> bets;  //Map<playerType,howMuch>
//
//    private Map<RoulettePlayer, Integer>  betOddEven;  // betting number
//    private  int winningNumber;  //dealer announce number
   private int  maxPlayers;
    private Map<RoulettePlayer, Integer> bets = new HashMap<>();  // betting amount for each player
    private Map<RoulettePlayer, String> myBetChoice = new HashMap<>();   //each player choice for Even/odd gto place
    private Map<RoulettePlayer, Boolean> winLose = new HashMap<>();
  private SpinWheel myWheel=new SpinWheel();
    private static Scanner scan = new Scanner(System.in);
    private boolean exitFlag = false;
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    public RouletteGame() {
    }


    /**
     * Looping through all players to setBet
     * check if bet< walletBalance
     *  adding in bets object
     *  applying bets
     *
     *  2nd  for loop  --> even/odd player choice to keep
     *  add myBetChoice.
     */
    @Override
    public void setBets () {

        Integer bet = 0, walletBalance;
        for (RoulettePlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            System.out.println("printing balance for:"+s.getPerson().getName()+"balance:"+walletBalance);
            try {
                System.out.println("Hello" +s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet=scan.nextInt();
                System.out.println("you entered bet amount of:"+bet);
                //bet=console.getIntegerInput("Enter your bet");
                if (bet>walletBalance || bet<0){
                    bet=console.getIntegerInput("Invalid bet, try again");
                    System.out.println("you entered bet amount of:"+bet);
                }
            } catch (InputMismatchException e){
                System.out.println("Not a number, try again");
                bet=scan.nextInt();
                System.out.println("you entered bet amount of:"+bet);
            }
            bets.put(s, bet);
            s.applyBet(bet);
        }
        String betchoice;
        //set player choice
        for (RoulettePlayer s: myBetChoice.keySet()){

            try {
                System.out.println("Hello " +s.getPerson().getName() + ", what is your bet choice?odd or even?");
                System.out.println();
                //betchoice=scan.next();
                betchoice=console.getStringInput("Enter your bet choice");
                if (betchoice.equals("odd") || betchoice.equals("even")){
                    System.out.println("choice entered");

                }
            } catch (InputMismatchException e){
                System.out.println("Not a correct choice, try again");
                continue;
            }
            System.out.println("adding betchoice for :"+s.getPerson().getName()+"choice:"+betchoice);
            myBetChoice.put(s,betchoice);
        }
    }



    @Override
    public void distributeWinningsToWinners (RoulettePlayer winner) {
        winner.addWinning(bets.get(winner)*3);
    }



    @Override
    public void play () {
        while (!exitFlag)
        {
            setBets();//how much and even or odd?
        System.out.println("Spinning...");

        SpinWheelResult spinwheelResult = myWheel.spin();

        System.out.println(String.format("Dropped into %s", spinwheelResult.toString()));

        //check for win condition
        for (RoulettePlayer s : myBetChoice.keySet()) {
            System.out.println("check for win condition:"+s.getPerson().getName()+"choice"+myBetChoice.get(s));

            winConditionCheck(s);
            if (winLose.get(s)) {

                distributeWinningsToWinners(s); //
                System.out.println("winner:"+s.getPerson().getName()+"balance"+s.getBalance());

            }
            else
            {
                System.out.println("You lost this time");
            }
         //   System.out.println("Dropped into %s" + spinwheelResult + "Winner name" + s.getPerson().getName());
        }
        exit();
       }

    }

  //  @Override
//    public void play1 () {
//
//        //Odd Even game
//
//        OddEven OddEven1 = new OddEven("Odd or Even", 2);
//        //odd/even:2, red/black:2 dozen:5 ind slots:35
//        System.out.println("Enter amount");
//        int betAmount = scan.nextInt();
//        OddEven1.place();// ask player for Odd or Even?
//        System.out.println("Spinning...");
//
//        SpinWheelResult spinwheelResult = myWheel.spin();
//
//        System.out.println(String.format("Dropped into %s",spinwheelResult));
//
//        if(OddEven1.isWinning(spinwheelResult))
//        {
//            System.out.println("****Congratulations : you win***");
//            OddEven1.pay(betAmount);
//        }
//        else
//        {
//            System.out.println("***Sorry: you lose ****");
//
//        }
//
//    }




    @Override
    public void setPlayerMax () {
        this.maxPlayers =4;

    }

    @Override
    public void addPlayer ( RoulettePlayer player ) {
        this.bets.put(player,0);
        this.myBetChoice.put(player,"");
    }

    @Override
    public void removePlayer ( RoulettePlayer player ) {
        this.bets.remove(player);
        this.myBetChoice.remove(player);
    }

    @Override
    public void winConditionCheck ( RoulettePlayer player ) {
        for ( RoulettePlayer s: myBetChoice.keySet()){
            if(  (myWheel.getNumber()%2 == 0 && myBetChoice.get(s).equals("even")) ||
                    (myWheel.getNumber()%2 == 1 && myBetChoice.get(s).equals(("odd"))))
            {
                this.winLose.put(player, true);
            }
            else
            {
                this.winLose.put(player, false);
            }
        }

    }

    @Override
    public void exit () {
        String input = console.getStringInput("Do you want to exit the game?");
        if (input.equalsIgnoreCase("Yes"))
            this.exitFlag=true;
        else {
            System.out.println("Let's continue");

        }

    }
    public int getMaxPartySize() {
        return maxPlayers;
    }

}
