package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.Game;

import java.util.Scanner;
import java.util.Stack;

public class WarGame extends Game {
    Boolean isCardGame = true;

    Scanner scanner = new Scanner(System.in);

    // I don't think I need a main method here as the game will be initiated in another class.

    public void warGame() { // ROUGH DRAFT
        // import deck (stack) (shuffled)
        // player1 = whoever
        // player2 = whoever else
        Stack<Deck> handPlayer1 = new Stack<Deck>();
        Stack<Deck> handPlayer2 = new Stack<Deck>();
        for (int i = 1; i <= 26; i++) { // deal cards
            handPlayer1.push(deck.pop());
            handPlayer2.push(deck.pop());
        }

        while (handPlayer1.size() < 52 && handPlayer2.size() < 52) {
            // player input - play card
            // if p1 > p2 vs p2>p1 vs tie - player output show card and winner
            // cards to winner
            // display hand size i.e. 26/52
        }

        if (handPlayer1.empty()) {
            // PLAYER2 WINS
        } else if (handPlayer2.empty()) {
            // PLAYER1 WINS
        }
    }


    // 2 players or 1v computer
    // how do they quit midgame?
    // war is a non-gambling game, right?


    // try test driven development - but hard since don't know where each piece is going
    // review generics lecture - Wei posted slides in watercrest, vandana got recording
    // pop stack(deck) to pull card


}
