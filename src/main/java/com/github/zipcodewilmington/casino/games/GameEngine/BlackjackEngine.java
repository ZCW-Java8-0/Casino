package com.github.zipcodewilmington.casino.games.GameEngine;

import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;

import java.util.Iterator;
import java.util.List;

public class BlackjackEngine extends GameEngine<BlackJackPlayer, BlackJack> {
    public BlackjackEngine(BlackJack game, List<BlackJackPlayer> players){
        super(game, players);
    }

    @Override
    public BlackJack getGame() {
        return new BlackJack(this.getPlayers());
    }
}
