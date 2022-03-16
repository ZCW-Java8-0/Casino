package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.Game;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class WarGame extends Game {
    Boolean isCardGame = true;

    Scanner scanner = new Scanner(System.in);

    // I don't think I need a main method here as the game will be initiated in another class.

    public void warGame() { // ROUGH DRAFT
        // import deck (stack/deque) (shuffled)
        // player1 = whoever
        // player2 = whoever else
        Deque<Deck> handPlayer1 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer1 = new Stack<Deck>();
        Deque<Deck> handPlayer2 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer2 = new Stack<Deck>();
        for (int i = 1; i <= 26; i++) { // deal cards
            handPlayer1.addFirst(deck.removeFirst());
            handPlayer2.addFirst(deck.removeFirst());
        }

        while (handPlayer1.size() < 52 && handPlayer2.size() < 52) {
            Deck player1Card = handPlayer1.removeFirst();
            Deck player2Card = handPlayer2.removeFirst();
            if(player1Card > player2Card) {
                handPlayer1.addLast(player1Card);
                handPlayer1.addLast(player2Card);
            } else if (player1Card < player2Card) {
                handPlayer2.addLast(player1Card);
                handPlayer2.addLast(player2Card);
            } else if (player1Card == player2Card) {
                // TIE
            }
            // player input - play card
            // if p1 > p2 vs p2>p1 vs tie - player output show card and winner
            // cards to winner
            // display hand size i.e. 26/52
            // pop stack(deck) to pull card
            // code for lose - one person is out of cards
        }

        if (handPlayer1.empty()) {
            // PLAYER2 WINS
        } else if (handPlayer2.empty()) {
            // PLAYER1 WINS
        }
    }


    // 2 players or 1v computer
    // how do they quit midgame?
    // war is a non-gambling game, right? CORRECT


    // try test driven development - but hard since don't know where each piece is going
    // review generics lecture - Wei posted slides in watercrest, vandana got recording



}
