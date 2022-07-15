package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Player;

public class ConnectFourPlayer extends Player implements PlayerInterface {
    int positionPlacement;
    Player player;
    CasinoAccount casinoAccount;

    public ConnectFourPlayer(Player player, CasinoAccount casinoAccount){
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public ConnectFourPlayer(){

    }

    public Player getPlayer(){
        return this.player;
    }

    public CasinoAccount getCasinoAccount(){
        return casinoAccount;
    }

    public int getPositionPlacement() {
        return positionPlacement;
    }
    public void setPositionPlacement(int chosenPosition) {
        this.positionPlacement = chosenPosition;
    }

//    @Override
    //public CasinoAccount getCasinoAccount() {
//        return null;
//    }
}
