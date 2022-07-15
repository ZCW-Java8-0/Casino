package com.github.zipcodewilmington.casino.games;

import com.sun.security.jgss.InquireSecContextPermission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName, suit;
    private int value;

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames(){
        return Arrays.asList("2","3","4","5","6","7","8","9","10",
                "jack","queen","king","ace");
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getValidFaceNames();
        faceName = faceName.toLowerCase();
        if (validFaceNames.contains(faceName)){
        this.faceName = faceName;}
        else
            throw new IllegalArgumentException("Valid face names are: " + validFaceNames);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits(){
        return Arrays.asList("hearts", "diamonds", "spades", "clubs");
    }

    public void setSuit(String suit) {
        List<String> validSuits = getValidSuits();
        suit = suit.toLowerCase();

        if (validSuits.contains(suit)) {
            this.suit = suit;
        }
        else
            throw new IllegalArgumentException("valid suits are: " + validSuits);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        if(value > 0 && value < 15) {
            this.value = value;
        }
        else{
            throw new IllegalArgumentException("Valid value is 1 to 14" );
        }
    }

    public String toString(){
        return String.format("%s of %s", faceName, suit);
    }

    public Card(String faceName, String suit, int value) {
        setFaceName(faceName);
        setSuit(suit);
        setValue(value);
    }
}
