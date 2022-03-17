package com.github.zipcodewilmington.casino.games.BlackJack;

public class Card {
    private Suit suit;
    private CardFace cardFace;

    public Card (CardFace cardFace, Suit suit){
        this.cardFace=cardFace;
        this.suit=suit;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public CardFace getCardFace() {
        return cardFace;
    }

    public void setCardFace(CardFace cardFace) {
        this.cardFace = cardFace;
    }

    public String toString(){
        return this.cardFace + " of " + this.suit;
    }
}
