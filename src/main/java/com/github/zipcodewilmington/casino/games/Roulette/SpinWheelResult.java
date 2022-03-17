package com.github.zipcodewilmington.casino.games.Roulette;

public class SpinWheelResult {
    private String myColor;
    private  int myNumber;

    public SpinWheelResult(String myColor,int myNumber)
    {
        this.myColor=myColor;
        this.myNumber=myNumber;
    }

    public String getColor()
    {
        return this.myColor;
    }

    public int getNumber()
    {
        return this.myNumber;
    }


}
