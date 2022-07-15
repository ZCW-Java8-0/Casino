package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Player;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player implements PlayerInterface {
    Player player;
    private int bet;
    CasinoAccount casinoAccount;

    public SlotsPlayer(Player player, CasinoAccount casinoAccount){
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public SlotsPlayer(){

    }

    public Player getPlayer(){
        return this.player;
    }

    public CasinoAccount getCasinoAccount(){
        return casinoAccount;
    }

   // public void setCasinoAccount(){
    //}


}