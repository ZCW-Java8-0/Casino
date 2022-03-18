package com.github.zipcodewilmington.casino.games.Roulette;
import java.util.Random;
public class SpinWheel {
    public static final String RED="red";
    public static final String BLACK="black";
    public static final String GREEN="green";

    private static final String[] WHEEL_SPOTS = {
     GREEN,
     RED,//1
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,
     RED,
     BLACK,//36
        //    GREEN
    };

    public static final int NUM_SPOTS = WHEEL_SPOTS.length;


    private int myValue;
    private Random myRoller;


    public SpinWheel()
    {

        myValue = 0;
        myRoller = new Random();
    }

    public SpinWheelResult spin()
    {
       myValue = myRoller.nextInt(WHEEL_SPOTS.length);
       //SpinWheelResult result = new SpinWheelResult();
       //result.getColor(myValue);
       //result.getNumber(myValue);
       //return result;
       // return new SpinWheelResult(getColor(),getNumber());
        return new SpinWheelResult(WHEEL_SPOTS[myValue],myValue);
    }

//    private String getColor()
//    {
//        return WHEEL_SPOTS[myValue];
//    }
//
//    private int getNumber()
//    {
//       return myValue;
//    }


}
