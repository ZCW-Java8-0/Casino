package com.github.zipcodewilmington.casino.games.connectfour;

import com.github.zipcodewilmington.utils.AnsiColor;

public class Token {
    static Character symbol = 'O';
    private AnsiColor color;
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLACK = "\u001B[30m";

//    Token() {
//        this.symbol = 'O';
//        this.ansiColor = AnsiColor.YELLOW;
//    }
//    Token() {
//    }
//    Token(AnsiColor color, Character ch) {
//    }

    Token(Character ch) {
        this.symbol = ch;
        System.out.print(ANSI_RED+symbol);
    }

    public Token(AnsiColor black) {
    }

//    @Override
//    public String toString() {
//        return color+String.valueOf(symbol);
//    }
}
