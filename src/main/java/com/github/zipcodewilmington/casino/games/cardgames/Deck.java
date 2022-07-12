package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.*;

public abstract class Deck<E> {
    protected Deque<E> cards;
    public void shuffle(List<E> cards) {
        Collections.shuffle(cards);
    }

    void shuffle() {
        List<E> tmp = new ArrayList<>(this.cards);
        Collections.shuffle(tmp);
        this.cards = new ArrayDeque<>(tmp);
    }

    protected E dealCard() {
        return cards.pop();
    }

    // insert a card to the bottom of deck
    protected void insertCardFromBottom(E card) {
        cards.offerLast(card);
    }

    public Deque<E> getCards() {
        return this.cards;
    }

    public int getDeckSize() {
        return cards.size();
    }

    protected abstract List<E> initCards();

    // reset Deck to a new shuffled state
    protected abstract void reset();

    public abstract void printCards();

}
