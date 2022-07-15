package com.github.zipcodewilmington.casino.games;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName, suit;

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

    public String toString(){
        return String.format("%s of %s", faceName, suit);
    }

    public Card(String faceName, String suit) {
        setFaceName(faceName);
        setSuit(suit);
    }
}
