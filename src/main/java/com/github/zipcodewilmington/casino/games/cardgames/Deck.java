package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.*;

public abstract class Deck<E> {
    protected Deque<E> cards;
    <E> void shuffle(List<E> cards) {
        Collections.shuffle(cards);
    }

    void shuffle() {
        List<E> tmp = new ArrayList<>(this.cards);
        Collections.shuffle(tmp);
        this.cards = new ArrayDeque<>(tmp);
    }

    abstract E dealCard();

    public Deque<E> getCards() {
        return this.cards;
    }

    int getDeckSize() {
        return cards.size();
    }

    abstract List<E> initCards();

    // reset Deck to a new shuffled state
    abstract void reset();

    abstract void printCards();

}
