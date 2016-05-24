package com.jiro.model;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;

public class Card {

    private CardSuit cardSuit;
    private CardNumber cardNumber;
    private boolean isVisible;
    private Deck deck;

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Card() {}

    public Card(CardNumber cardNumber, CardSuit cardSuit) {
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return cardNumber.getSymbol() + cardSuit.getSymbol();
    }
}
