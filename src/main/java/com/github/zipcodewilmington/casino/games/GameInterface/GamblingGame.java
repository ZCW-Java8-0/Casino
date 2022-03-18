package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Map;

public interface GamblingGame <PlayerType extends Player> extends Games<PlayerType>{
    void setBets();


    Map<Player, Boolean> winCondition ();

    void distributeWinningsToWinners(PlayerType winner);

}
