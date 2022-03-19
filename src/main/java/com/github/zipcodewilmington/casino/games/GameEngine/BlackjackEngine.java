package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;

import java.util.List;

public class BlackjackEngine extends GameEngine<BlackJackPlayer, BlackJack> {
    public BlackjackEngine(BlackJack game, List<BlackJackPlayer> players){
        super(game, players);
    }

    @Override
    public void start() {
        for (BlackJackPlayer s: getPlayers()){
            getGame().addPlayer(s);
        }
        getGame().play();
    }
}
