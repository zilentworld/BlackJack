package com.jiro.enums;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum CardSuit {
    CLUB("club", "C"),
    HEART("heart", "H"),
    SPADE("spade", "S"),
    DIAMOND("diamond", "D");

    private String suit;
    private String symbol;

    CardSuit(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
