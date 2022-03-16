package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.Game;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class WarGame extends Game {
     NON-GAMBLING
    Boolean isCardGame = true;

    Scanner scanner = new Scanner(System.in);

    // I don't think I need a main method here as the game will be initiated in another class.

    public void warGame() { // ROUGH DRAFT
        // import deck (stack/deque) (shuffled)
        // player1 = whoever
        // player2 = whoever else
        Deque<Deck> handPlayer1 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer1 = new Stack<Deck>();
        Deque<Deck> handPlayer2 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer2 = new Stack<Deck>();
        Deque<Deck> temporary = new ArrayDeque<Deck>();
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
                System.out.println("Player 1: " + player1Card); // rename players to account names
                System.out.println("Player 2: " + player2Card); // rename players to account names
                System.out.println("Player 1 Wins This Round!"); // rename players to account names
                System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
                // to account names
                System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
                // to account names
            } else if (player1Card < player2Card) {
                handPlayer2.addLast(player1Card);
                handPlayer2.addLast(player2Card);
                System.out.println("Player 1: " + player1Card); // rename players to account names
                System.out.println("Player 2: " + player2Card); // rename players to account names
                System.out.println("Player 2 Wins This Round!"); // rename players to account names
                System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
                // to account names
                System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
                // to account names
            } else if (player1Card == player2Card) {
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());


                // TIE -- what if they run out of cards???
                // catch out of cards and use last care in pile
            }
        }

        if (handPlayer1.empty()) {
            // PLAYER2 WINS
        } else if (handPlayer2.empty()) {
            // PLAYER1 WINS
        }
    }


     2 players or 1v computer
     how do they quit midgame?


     try test driven development - but hard since don't know where each piece is going
     review generics lecture - Wei posted slides in watercrest, vandana got recording



}
