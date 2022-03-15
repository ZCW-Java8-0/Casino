package com.github.zipcodewilmington.casino;

public class Player implements PlayerInterface{
    private String accountName = "";
    private int chips;


    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
    public Player(){}
  public Player(String accountName,int chips){
        this.accountName = accountName;
        this.chips = chips;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }
}
