package com.jiro.model;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;

/**
 * Created by dev-pc on 5/23/16.
 */
public class Card {

    private CardSuit cardSuit;
    private CardNumber cardNumber;
    private Player player;
    private boolean isVisible;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    @Override
    public String toString() {
        return cardNumber.getSymbol() + cardSuit.getSymbol();
    }
}
