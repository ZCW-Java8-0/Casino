package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.utils.AnsiColor;

public class Token {
    static Character symbol = 'O';
    private AnsiColor color;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";

//    Token() {
//        this.symbol = 'O';
//        this.ansiColor = AnsiColor.YELLOW;
//    }
    Token() {
    }
    Token(AnsiColor color, Character ch) {
    }

    Token(AnsiColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color+String.valueOf(symbol);
    }
}
