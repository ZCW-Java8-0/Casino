package com.github.zipcodewilmington.interfaces;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface<PlayerType extends PlayerInterface> extends Runnable {
    Boolean isOver();

    /**
     * adds a player to the game
     * @param player the player to be added to the game
     */
    void addPlayer(PlayerType player);

    /**
     * adds players to the game
     * @param player the players to be added to the game
     */
    void addPlayers(List<? extends PlayerType> player);

    /**
     * evaluates player's turn
     * @param player the player's whose turn is to be evaluated
     */
    void evaluateTurn(PlayerType player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(PlayerType player);

    /**
     * specifies how the game will run
     */
    void run();


}

