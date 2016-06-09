package com.jiro.model;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;

import java.io.Serializable;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
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
        this.isVisible = true;
    }

    public Card(CardNumber cardNumber, CardSuit cardSuit, boolean isVisible) {
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
        this.isVisible = isVisible;
    }

    public Card(String fromDb) {
        String[] splitz = fromDb.split("!");
        if (splitz.length > 1) {
            cardNumber = CardNumber.findBySymbol(splitz[0]);
            cardSuit = CardSuit.findBySymbol(splitz[1]);
        }
        this.isVisible = true;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        if (isVisible)
            return cardNumber.getSymbol() + cardSuit.getSymbol();
        else
            return "??";
    }

    public String toDbFormat() {
        return cardNumber.getSymbol() + "!" + cardSuit.getSymbol();
    }

    public int getSoftValue() {
        return cardNumber.getSoftValue();
    }

    public int getHardValue() {
        return cardNumber.getHardValue();
    }
}
