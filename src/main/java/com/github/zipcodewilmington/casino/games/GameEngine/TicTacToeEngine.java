package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.RockPaperScissor.RockPaperScissorPlayer;
import com.github.zipcodewilmington.casino.games.TicTacToe.TicTacToeGame;
import com.github.zipcodewilmington.casino.games.TicTacToe.TicTacToePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class TicTacToeEngine extends GameEngine<TicTacToePlayer, TicTacToeGame> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public TicTacToeEngine(TicTacToeGame game, List<TicTacToePlayer> players){
        super(game, players);
    }

    @Override
    public void start() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts();
        String input = console.getStringInput("Player 2 please login");
        while(getPlayers().size() != 2){
            getPlayers().add(new TicTacToePlayer(casinoAccountManager.accountLogin().getProfile()));
            input=console.getStringInput("More players? (Yes/No)");
        }
        for (TicTacToePlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
