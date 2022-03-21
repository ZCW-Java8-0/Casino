package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoGame;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class CeeLoEngine extends GameEngine<CeeLoPlayer, CeeLoGame> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    public CeeLoEngine(CeeLoGame game, CeeLoPlayer player){
        super(game, player);
    }

    @Override
    public void start() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.loadAccounts();
        System.out.println("Player 2 please enter login information");
        while(getPlayers().size() < 2){
            getPlayers().add(new CeeLoPlayer(casinoAccountManager.accountLogin().getProfile()));
        }
        for (CeeLoPlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
