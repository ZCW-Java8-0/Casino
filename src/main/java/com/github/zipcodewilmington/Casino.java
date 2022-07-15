package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.connectfour.ConnectFour;
import com.github.zipcodewilmington.casino.games.connectfour.ConnectFourPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Objects;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        try{
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();

            if ("2".equals(arcadeDashBoardInput)) { //log-in

                    String accountName = console.getStringInput("Enter your account name:");
                    String accountPassword = console.getStringInput("Enter your account password:");
                    CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                    boolean isValidLogin = casinoAccount != null;
                    if (isValidLogin) {
                        displayGameMenu();


                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                        throw new RuntimeException(String.format(errorMessage, accountName, accountPassword));
                    }



        } else if ("1".equals(arcadeDashBoardInput)) { //create-account
            console.println("Welcome to the account-creation screen.");
            String accountName = console.getStringInput("Enter your account name:");
            String accountPassword = console.getStringInput("Enter your account password:");
            CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
            casinoAccountManager.registerAccount(newAccount);
            displayGameMenu();
        }

    } while(!"logout".equals(arcadeDashBoardInput));
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
}

    private void displayGameMenu(){
        String gameSelectionInput = getGameSelectionInput().toUpperCase();
        if (gameSelectionInput.equals("1")) { //slots
            play(new SlotsGame(), new SlotsPlayer());
//                    } else if (gameSelectionInput.equals("2")) { //cee-lo
//                        play(new CeeloGame(), new CeeloPlayer());
//                    } else if (gameSelectionInput.equals("3")) { //chuck a luck
//                        play(new ChuckALuckGame(), new ChuckALuckPlayer());
        } else if (gameSelectionInput.equals("4")) { //connect four
            play(new ConnectFour(), new ConnectFourPlayer());
//                    } else if (gameSelectionInput.equals("5")) { //blackjack
//                        play(new BlackjackGame(), new BlackjackPlayer());
//                    }else if (gameSelectionInput.equals("6")) { //war
//                        play(new WarGame(), new WarPlayer());
        } else {
            // TODO - implement better exception handling
            String errorMessage = "[ %s ] is an invalid game selection";
            throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
        }
    }


    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1. create-account ], [ 2. log-in ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1. SLOTS ], [ 2. CEE-LO ], [ 3. CHUCK A LUCK], [ 4. CONNECT 4 ], [ 5. BLACKJACK ], [ 6. WAR ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface) gameObject;
        PlayerInterface player = (PlayerInterface) playerObject;
        game.add(player);
        game.run();
    }
}
