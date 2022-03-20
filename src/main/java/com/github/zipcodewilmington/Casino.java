package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.GameEngine.BlackjackEngine;
import com.github.zipcodewilmington.casino.games.GameInterface.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoGame;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                boolean isValidLogin;
                CasinoAccount casinoAccount;
                do {
                    String accountName = console.getStringInput("Enter your account name:");
                    String accountPassword = console.getStringInput("Enter your account password:");
                    casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                    isValidLogin = casinoAccount != null;
                } while (!isValidLogin);
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                    } else if (gameSelectionInput.equals("BLACKJACK")) {
                        List<BlackJackPlayer> blackJackPlayerList = new ArrayList<>();
                        blackJackPlayerList.add(new BlackJackPlayer(casinoAccount.getProfile()));
                        new BlackjackEngine( new BlackJack(), blackJackPlayerList).start();
                    } else if (gameSelectionInput.equals("CEELO")) {
                        List<CeeLoPlayer> ceeLoPlayerList = new ArrayList<>();
                        ceeLoPlayerList.add(new CeeLoPlayer(casinoAccount.getProfile()));
                        new CeeLoGame(ceeLoPlayerList).play();
                    } else if (gameSelectionInput.equals("ROUTLETTE")) {
                        List<RoulettePlayer> roulettePlayerList = new ArrayList<>();
                        roulettePlayerList.add(new RoulettePlayer(casinoAccount.getProfile()));
                        //roulette play call here
                        new RouletteGame(roulettePlayerList).play();
                    } else if (gameSelectionInput.equals("TICTACTOE")) {
                    } else if (gameSelectionInput.equals("ROCKPAPERSCISSOR")) {
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found.";
                    throw new RuntimeException(String.format(errorMessage));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
                String name = console.getStringInput("Enter your name:");
                Integer funds = console.getIntegerInput("Enter how much money you want to put in:");
                newAccount.createProfile(name, funds);
            } else if ("change-password".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your current account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    accountPassword = console.getStringInput("Enter your new account password:");
                    casinoAccount.setAccountPassword(accountPassword);
                }
            }
        } while (!"logout".equals(arcadeDashBoardInput));
        casinoAccountManager.saveAccounts();
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ change-password ], [ select-game ] [ logout ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ BLACKJACK ], [ CEELO ], [ ROULETTE ], [ TICTACTOE ]" +
                        ", [ ROCKPAPERSCISSOR ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
