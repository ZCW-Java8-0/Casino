package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.RockPaperScissor.RockPaperScissorGame;
import com.github.zipcodewilmington.casino.games.RockPaperScissor.RockPaperScissorPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class RockPaperScissorEngine extends GameEngine<RockPaperScissorPlayer, RockPaperScissorGame> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public RockPaperScissorEngine(RockPaperScissorGame game, RockPaperScissorPlayer player){
        super(game, player);
    }

    @Override
    public void start() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts();
        String input = console.getStringInput("Player 2 please login");
        while(getPlayers().size() != 2){
            getPlayers().add(new RockPaperScissorPlayer(casinoAccountManager.accountLogin().getProfile()));
            input=console.getStringInput("More players? (Yes/No)");
        }
        for (RockPaperScissorPlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
