<<<<<<< HEAD
package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.cards.Cards;
import com.github.zipcodewilmington.casino.cards.Deck;
import java.util.Collections;
import java.util.*;

public class WarGame extends Game { // NON-GAMBLING // ROUGH DRAFT

    Boolean isCardGame = true;

    Scanner scanner = new Scanner(System.in);

    Deque<Cards> temporary = new ArrayDeque<Cards>();
    Deque<Cards> handPlayer1 = new ArrayDeque<Cards>();
    Deque<Cards> handPlayer2 = new ArrayDeque<Cards>();

    // I don't think I need a main method here as the game will be initiated in another class.

    public void warGame() {
        // assign players
        String player1 = "PLAYER1"; // update this piece
        String player2 = "PLAYER2"; // update this piece

        // create decks and deal cards
        ArrayDeque<Cards> deck = createWarDeck();
        for (int i = 1; i <= 26; i++) {
            handPlayer1.addFirst(deck.removeFirst());
            handPlayer2.addFirst(deck.removeFirst());
        }

        // gameplay
        while (handPlayer1.size() < 52 && handPlayer2.size() < 52) {
            Cards player1Card = handPlayer1.removeFirst();
            Cards player2Card = handPlayer2.removeFirst();
            compareAndRedistribute(player1Card, player2Card);
        }

        // declare a winner
        if (handPlayer1.size() == 0) {
            // PLAYER2 WINS
        } else if (handPlayer2.size() == 0) {
            // PLAYER1 WINS
        }
    }


    // 2 players or 1v computer
    // how do they quit midgame?
// clear temporary at end so no carry over betwen games?
    // player input/output???

    // try test driven development - but hard since don't know where each piece is going
    // review generics lecture - Wei posted slides in watercrest, vandana got recording

    // ============================= SUB-METHODS =============================

    public ArrayDeque<Cards> createWarDeck() {
        Deck deck = new Deck();
        ArrayList<Cards> deckOfCards = deck.createDeck();
        ArrayList<Cards> shuffledDeckOfCards = shuffle(deckOfCards);
        ArrayDeque<Cards> startingDeck = new ArrayDeque<>(shuffledDeckOfCards);
        return startingDeck;
    }

    public ArrayList<Cards> shuffle(ArrayList<Cards> inputDeck) {
        Collections.shuffle(inputDeck);
        return inputDeck;
    }

    public void distributeTemporaryCards(Deque<Cards> handOfWinner) {
        for (int t = 1; t <= temporary.size(); t++) {
            handOfWinner.addLast(temporary.removeFirst());
        }
    }

    public void compareAndRedistribute(Cards player1Card, Cards player2Card) {
        int tierCard1 = player1Card.getTier();
        int tierCard2 = player2Card.getTier();
        if (tierCard1 > tierCard2) {
            handPlayer1.addLast(player1Card);
            handPlayer1.addLast(player2Card);
            distributeTemporaryCards(handPlayer1);
            System.out.println("Player 1: " + player1Card); // rename players to account names
            System.out.println("Player 2: " + player2Card); // rename players to account names
            System.out.println("Player 1 Wins This Round!"); // rename players to account names
            System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
            // to account names
            System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
            // to account names

        } else if (tierCard1 < tierCard2) {
            handPlayer2.addLast(player1Card);
            handPlayer2.addLast(player2Card);
            distributeTemporaryCards(handPlayer2);
            System.out.println("Player 1: " + player1Card); // rename players to account names
            System.out.println("Player 2: " + player2Card); // rename players to account names
            System.out.println("Player 2 Wins This Round!"); // rename players to account names
            System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
            // to account names
            System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
            // to account names

        } else if (tierCard1 == tierCard2) { // what if that was the last card for one of them?
            if (handPlayer1.size() > 3 && handPlayer2.size() > 3) {
                temporary.addFirst(handPlayer1.removeFirst()); // make sub-method w/ player parameter to...
                temporary.addFirst(handPlayer1.removeFirst()); // ...move 3 cards to temp
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                return;
            } else if (handPlayer1.size() > 3 && handPlayer2.size() < 3) {
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer1.removeFirst());
                temporary.addFirst(handPlayer1.removeFirst());
                while (handPlayer2.size() > 1) {
                    temporary.addFirst(handPlayer2.removeFirst());
                }
                return;
            } else if (handPlayer1.size() < 3 && handPlayer2.size() > 3) {
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                temporary.addFirst(handPlayer2.removeFirst());
                while (handPlayer1.size() > 1) {
                    temporary.addFirst(handPlayer1.removeFirst());
                }
                return;
            } else {
                while (handPlayer1.size() > 1) {
                    temporary.addFirst(handPlayer1.removeFirst());
                }
                while (handPlayer2.size() > 1) {
                    temporary.addFirst(handPlayer2.removeFirst());
                }
                return;
            }
        }
    }
    }
=======
//package com.github.zipcodewilmington.casino.games.war;
//
//import com.github.zipcodewilmington.casino.Game;
//
//import java.util.ArrayDeque;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class WarGame implements GameInterface<WarPlayer> {
//
//    // NON-GAMBLING
//    Boolean isCardGame = true;
//
//    Scanner scanner = new Scanner(System.in);
//
//    Deque<Deck> temporary = new ArrayDeque<Deck>();
//
//    // I don't think I need a main method here as the game will be initiated in another class.
//
//    public void warGame() { // ROUGH DRAFT
//        // import deck (stack/deque) (shuffled)
//        // player1 = whoever
//        // player2 = whoever else
//        Deque<Deck> handPlayer1 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer1 = new Stack<Deck>();
//        Deque<Deck> handPlayer2 = new ArrayDeque<Deck>(); // Stack<Deck> handPlayer2 = new Stack<Deck>();
//        for (int i = 1; i <= 26; i++) { // deal cards
//            handPlayer1.addFirst(deck.removeFirst());
//            handPlayer2.addFirst(deck.removeFirst());
//        }
//
//        while (handPlayer1.size() < 52 && handPlayer2.size() < 52) {
//            Deck player1Card = handPlayer1.removeFirst();
//            Deck player2Card = handPlayer2.removeFirst();
//            compareAndRedistribute(player1Card, player2Card);
//        }
//
//        if (handPlayer1.empty()) {
//            // PLAYER2 WINS
//        } else if (handPlayer2.empty()) {
//            // PLAYER1 WINS
//        }
//    }
//
//
//    // 2 players or 1v computer
//    // how do they quit midgame?
//// clear temporary at end so no carry over betwen games?
//    // player input/output???
//
//    // try test driven development - but hard since don't know where each piece is going
//    // review generics lecture - Wei posted slides in watercrest, vandana got recording
//
//
//    public void distributeTemporaryCards(WINNING PLAYER) {
//        for (int t = 1; t <= temporary.size; t++) {
//            // distribute cards to winning player
//        }
//    }
//
//    public void compareAndRedistribute(Deck player1Card, Deck player2Card) {
//        if (player1Card > player2Card) {
//            handPlayer1.addLast(player1Card);
//            handPlayer1.addLast(player2Card);
//            distributeTemporaryCards(PLAYER 1);
//            System.out.println("Player 1: " + player1Card); // rename players to account names
//            System.out.println("Player 2: " + player2Card); // rename players to account names
//            System.out.println("Player 1 Wins This Round!"); // rename players to account names
//            System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
//            // to account names
//            System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
//            // to account names
//
//        } else if (player1Card < player2Card) {
//            handPlayer2.addLast(player1Card);
//            handPlayer2.addLast(player2Card);
//            distributeTemporaryCards(PLAYER 2);
//            System.out.println("Player 1: " + player1Card); // rename players to account names
//            System.out.println("Player 2: " + player2Card); // rename players to account names
//            System.out.println("Player 2 Wins This Round!"); // rename players to account names
//            System.out.println("Player 1 Has " + handPlayer1.size() + " cards."); // rename players
//            // to account names
//            System.out.println("Player 2 Has " + handPlayer2.size() + " cards."); // rename players
//            // to account names
//
//        } else if (player1Card == player2Card) { // what if that was the last card for one of them?
//            if (handPlayer1.size() > 3 && handPlayer2.size() > 3) {
//                temporary.addFirst(handPlayer1.removeFirst()); // make sub-method w/ player parameter to...
//                temporary.addFirst(handPlayer1.removeFirst()); // ...move 3 cards to temp
//                temporary.addFirst(handPlayer1.removeFirst());
//                temporary.addFirst(handPlayer2.removeFirst());
//                temporary.addFirst(handPlayer2.removeFirst());
//                temporary.addFirst(handPlayer2.removeFirst());
//                return;
//            } else if (handPlayer1.size() > 3 && handPlayer2.size() < 3) {
//                temporary.addFirst(handPlayer1.removeFirst());
//                temporary.addFirst(handPlayer1.removeFirst());
//                temporary.addFirst(handPlayer1.removeFirst());
//                while (handPlayer2.size > 1) {
//                    temporary.addFirst(handPlayer2.removeFirst());
//                }
//                return;
//            } else if (handPlayer1.size() < 3 && handPlayer2.size() > 3) {
//                temporary.addFirst(handPlayer2.removeFirst());
//                temporary.addFirst(handPlayer2.removeFirst());
//                temporary.addFirst(handPlayer2.removeFirst());
//                while (handPlayer1.size > 1) {
//                    temporary.addFirst(handPlayer1.removeFirst());
//                }
//                return;
//                } else {
//                    while (handPlayer1.size > 1) {
//                        temporary.addFirst(handPlayer1.removeFirst());
//                    }
//                    while (handPlayer2.size > 1) {
//                        temporary.addFirst(handPlayer2.removeFirst());
//                    }
//                    return;
//                }
//            }
//        }
//    }
>>>>>>> 84d5f9c6e2f146bddee43ed7cea611c94b8dd5a1
