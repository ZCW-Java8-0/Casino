package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface<PlayerType extends PlayerInterface> extends Runnable {
    Boolean isOver();

    /**
     * adds a player to the game
     * @param player the player to be added to the game
     */
    void add(PlayerType player);

    /**
     * adds players to the game
     * @param player the players to be added to the game
     */
    void addPlayers(Iterable<? extends PlayerType> player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(PlayerInterface player);

    /**
     * specifies how the game will run
     */
    void run();

    void testMethod();
}

