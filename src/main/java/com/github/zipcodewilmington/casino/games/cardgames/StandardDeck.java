package com.github.zipcodewilmington.casino.games.cardgames;


import java.util.*;

public class StandardDeck extends Deck<PlayingCard> {

    public StandardDeck() {
        List<PlayingCard> newCards = initCards();
        shuffle(newCards);
        super.cards = new ArrayDeque<>(newCards);
    }

    // pop card from top of deck
    public PlayingCard dealCard() {
        return super.cards.pop();
    }

    // insert a card to the bottom of deck
    public void insertCardFromBottom(PlayingCard card) {
        super.cards.offerLast(card);
    }

    // reset cards to a new shuffled state
    public void reset() {
        List<PlayingCard> newCards = initCards();
        shuffle(newCards);
        super.cards = new ArrayDeque<>(newCards);
    }

    protected List<PlayingCard> initCards() {
        List<PlayingCard> newCards = new ArrayList<>();
        for (CardRank r : CardRank.values()) {
            for (CardSuit s : CardSuit.values()) {
                newCards.add(new PlayingCard(s, r));
            }
        }
        return newCards;
    }
    // TODO: Add graphic console representation of Deck
    public void printCards() {
    }

}
