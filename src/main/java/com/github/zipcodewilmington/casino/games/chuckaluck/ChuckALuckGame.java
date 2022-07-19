package com.github.zipcodewilmington.casino.games.chuckaluck;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.casino.games.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class ChuckALuckGame implements GameInterface {
    private final IOConsole Red = new IOConsole(AnsiColor.RED);
    private final IOConsole Green = new IOConsole(AnsiColor.GREEN);
    private final IOConsole Yellow = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole Blue = new IOConsole(AnsiColor.BLUE);
    private static final IOConsole Purple = new IOConsole(AnsiColor.PURPLE);
    private static final IOConsole Cyan = new IOConsole(AnsiColor.CYAN);
    private Integer betType = 0;
    private IOConsole console = new IOConsole();
    private int d1Value;
    private int d2Value;
    private int d3Value;
    private int bet;
    private int winnings;
    private int balance = 500;
    Dice d6 = new Dice(1);


    public static void playChuckALuckGame() {
        ChuckALuckGame game = new ChuckALuckGame();
        game.welcome();
        game.printRules();
        System.out.println(game.welcomeDice1());
        System.out.println(game.welcomeDice2());
        Boolean quit = false;
        System.out.print("YOUR CURRENT BALANCE IS: " + game.balance + "\n");
        game.setBet();
        while(!quit) {
            game.askBetType();
            game.tossDice1();
            game.tossDice2();
            game.tossDice3();
            game.showRolls();
            game.printWinOrLose();
            System.out.println("SUM: " + game.sumDice() + "\n");
            game.winYN();
            game.adjustBalance();
            System.out.println("YOUR NEW BALANCE IS: " + game.balance + "\n\n");
            Integer input = Purple.getIntegerInput("PLAY AGAIN?\n\n" +
                    "1.YES  2.NO  3.CHANGE BET");
            if (input == 2) {
                quit = true;
            } else if (input == 3) {
                game.setBet();
            }
        }
    }
    public void setBet () {
        this.bet = Yellow.getIntegerInput("ENTER YOUR WAGER: ");
    }


    public Integer adjustBalance() {
        if (winYN()) {
            balance += bet*1.5;
        } else if(winYN() && betType == 3) {
            balance += bet*500;
        } else balance -= bet;
        return balance;
    }

    public void welcome() {
                Blue.println("\n\n\n"+
            "██████ ██   ██ ██    ██  ██████ ██   ██      █████      ██      ██    ██  ██████ ██   ██ ██\n" +
            "██     ██   ██ ██    ██ ██      ██  ██      ██   ██     ██      ██    ██ ██      ██  ██  ██\n" +
            "██     ███████ ██    ██ ██      █████       ███████     ██      ██    ██ ██      █████   ██\n" +
            "██     ██   ██ ██    ██ ██      ██  ██      ██   ██     ██      ██    ██ ██      ██  ██    \n" +
            "██████ ██   ██  ██████   ██████ ██   ██     ██   ██     ███████  ██████   ██████ ██   ██ ██");

    }
    public String welcomeDice1() {
        return
                        "  ____\n" +
                        " /\\' .\\     _____\n" +
                        "/: \\___\\   / .  /\\\n" +
                        "\\' / . /  /____/..\\\n" +
                        " \\/___/   \\'  '\\  /\n" +
                        "           \\'__'\\/";
    }
    public String welcomeDice2() {
        return
                        "\t  ____\n" +
                        "\t /\\': \\\n" +
                        "\t/  \\___\\\n" +
                        "\t\\' / : /\n" +
                        "\t \\/___/\n";
    }
    public void printRules() {
        System.out.println("\nTRY YOUR LUCK AGAINST THE ROLLS OF THE DICE!");
    }
    public Integer askBetType() {
        betType =Yellow.getIntegerInput("\nWHAT DO YOU WANT TO BET ON? \n\n" +
                "1. HIGH\n" +
                // -- TOTAL OF 3 DICE > 10
                "2. LOW\n" +
                // -- TOTAL OF 3 DICE < 11
                "3. FIELD\n" +
                // -- Total of 3 dice < 8 OR > 12
                "4. TRIPLES");
                // -- FEELING LUCKY?? WIN BIG IF ALL 3 DICE SHOW THE SAME NUMBER!
        return betType;
    }

    public Integer tossDice1() {
        d1Value = d6.tossAndSum();
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
        System.out.println("\nROLLS: " + d1Value + " " + d2Value + " " + d3Value);
    }
    public Integer sumDice() {
        return d1Value + d2Value + d3Value;
    }


//    public boolean resultIsTriple() {
//        return tossDice1() == tossDice2() && tossDice1() == tossDice3();
//    }
//    public boolean resultIsField() {
//        return sumDice() < 8 && sumDice() > 12;
//    }
//    public boolean isLow() {
//        return sumDice() < 11;
//    }

    public boolean winYN() {
        Integer sum = sumDice();
        if (betType == 1 && sum > 10) {
            return true;
        } else if (betType == 2 && sum < 11) {
            return true;
        } else if (betType == 3 && (sum < 8 && sum > 12)) {
            return true;
        } else if (betType == 4 && (tossDice1() == tossDice2() && tossDice1() == tossDice3())) {
            return true;
        }
        else return false;
    }

    public void printWinOrLose() {
        if (winYN()) {
            Green.println("*********************");
            Green.println("YOU WIN!!");
            Green.println("*********************\n");
        } else {
            Red.println("*********************");
            Red.println("OH NO! YOU LOST.");
            Red.println("*********************\n");
        }
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        playChuckALuckGame();

    }
}
