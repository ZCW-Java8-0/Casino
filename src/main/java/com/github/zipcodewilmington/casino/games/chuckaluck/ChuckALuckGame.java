package com.github.zipcodewilmington.casino.games.chuckaluck;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Dice;
import com.github.zipcodewilmington.casino.games.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class ChuckALuckGame implements GameInterface {
    private Integer betType = 0;
    private IOConsole console = new IOConsole();
    private int d1Value;
    private int d2Value;
    private int d3Value;
    private int bet;

    Dice d6 = new Dice(1);

    public void setBet () {
        this.bet = console.getIntegerInput("Enter your bet: ");
    }

    public String welcome() {
        return
                "\n\n\n"+
            "██████ ██   ██ ██    ██  ██████ ██   ██      █████      ██      ██    ██  ██████ ██   ██ ██\n" +
            "██     ██   ██ ██    ██ ██      ██  ██      ██   ██     ██      ██    ██ ██      ██  ██  ██\n" +
            "██     ███████ ██    ██ ██      █████       ███████     ██      ██    ██ ██      █████   ██\n" +
            "██     ██   ██ ██    ██ ██      ██  ██      ██   ██     ██      ██    ██ ██      ██  ██    \n" +
            "██████ ██   ██  ██████   ██████ ██   ██     ██   ██     ███████  ██████   ██████ ██   ██ ██";

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
        System.out.println("\nTry your luck against the roll of the dice!");
    }

    public Integer askBetType() {
        betType =console.getIntegerInput("\nWhat do you want to bet on? \n\n" +
                "Types of bets:\n\n" +
                "1. High -- Total of 3 dice > 10\n" +
                "2. Low -- Total of 3 dice < 11\n" +
                "3. Field -- Total of 3 dice < 8 OR > 12\n" +
                "4. Triples -- Feeling lucky? Win big if all three dice show the same number!");
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
        System.out.println("\nDice: " + d1Value + " " + d2Value + " " + d3Value);
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

    public boolean win() {
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
        if (win()) {
            System.out.println("You Win!");
        } else System.out.println("You lose.");
    }

    public static void playChuckALuckGame() {
        ChuckALuckGame game = new ChuckALuckGame();
        System.out.println(game.welcome());
        game.printRules();
        System.out.println(game.welcomeDice1());
        System.out.println(game.welcomeDice2());
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
