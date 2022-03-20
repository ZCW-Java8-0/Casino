package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class BlackjackEngine extends GameEngine<BlackJackPlayer, BlackJack> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public BlackjackEngine(BlackJack game, List<BlackJackPlayer> players){
        super(game, players);
    }

    @Override
    public void start() {
        getGame().setPlayerMax();
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts();
        String input = console.getStringInput("Do you want to add more players to the game? (Yes/no)");
        while(input.equalsIgnoreCase("yes") && getPlayers().size() < getGame().getMaxPartySize()){
            getPlayers().add(new BlackJackPlayer(casinoAccountManager.accountLogin().getProfile()));
            input=console.getStringInput("More players? (Yes/No)");
        }
        for (BlackJackPlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
