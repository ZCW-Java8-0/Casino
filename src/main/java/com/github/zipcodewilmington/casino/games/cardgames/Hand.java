package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public PlayingCard getCard(int index) {
        return cards.get(index);
    }

    public PlayingCard removeAndReturnCard(int index) {
        PlayingCard card = cards.get(index);
        cards.remove(card);
        return card;
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void clearHand() {
        cards.clear();
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void swapCard(PlayingCard card, int index) {
        try {
            cards.set(index, card);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no card at that position!");
        }
    }

    // TODO: call playing card toString or printCard methods instead
    public void printHand() {
        for (PlayingCard card : cards) {
            System.out.print(card.getSuit().toString() + " " + card.getRank().toString());
        }
    }
}
