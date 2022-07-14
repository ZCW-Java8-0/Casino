package com.github.zipcodewilmington.casino.games.chuckaluck;

import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Optional;

public class ChuckALuck {
    private Integer betType = 0;
    private IOConsole console = new IOConsole();
    private int d1Value;
    private int d2Value;
    private int d3Value;


    Dice d6 = new Dice(1);


    String s = ("Betting Options \n\n"
            + "Type of Bet:       Condition:			                    Odds:\n"
            + "1. High	     	   Total of 3 dice > 10                      1:1\n"
            + "2. Low	     	   Total of 3 dice < 11            	         1:1\n"
            + "3. Field           Total of 3 dice < 8 or total is > 12      1:1\n"
            + "4. Triples		   All 3 dice show same number              30:1");

    public void printRules() {
        System.out.println(s);
    }

    public Integer askBetType() {
        betType = console.getIntegerInput("\nPlace a bet: \n1. High\n2. Low\n3. Field\n4. Triples");
        return betType;
    }

    public Integer tossDice1() {
        d1Value = 1;
        return d1Value;
    }
    public Integer tossDice2() {
        this.d2Value = d6.tossAndSum();
        return d2Value;
    }
    public Integer tossDice3() {
        this.d3Value = d6.tossAndSum();
        return d3Value;
    }

    public void showRolls() {
        System.out.println("\nDice: " + d1Value + " " + d2Value + " " + d3Value);
    }
    public Integer sumDice() {
        return d1Value + d2Value + d3Value;
    }


    public boolean resultIsTriple() {
        return tossDice1() == tossDice2() && tossDice1() == tossDice3();
    }
    public boolean resultIsField() {
        return sumDice() < 8 && sumDice() > 12;
    }
    public boolean isLow() {
        return sumDice() < 11;
    }

    public boolean win() {
        Integer sum = sumDice();
        if (betType == 1 && sum > 10) {
            return true;
        } else return false;
    }

    public void printWinOrLose() {
        if (win()) {
            System.out.println("You Win!");
        } else System.out.println("You lose.");
    }

    public static void main(String[] args) {
        ChuckALuck game = new ChuckALuck();
        game.printRules();
        while(true) {
            game.askBetType();
            game.tossDice1();
            game.tossDice2();
            game.tossDice3();
            game.showRolls();
            game.printWinOrLose();
            System.out.println(game.sumDice());
        }
    }
}
