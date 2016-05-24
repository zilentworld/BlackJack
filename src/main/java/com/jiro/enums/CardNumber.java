package com.jiro.enums;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum CardNumber {
    ACE("ace", "A"),
    TWO("two", "2"),
    THREE("three", "3"),
    FOUR("four", "4"),
    FIVE("five", "5"),
    SIX("six","6"),
    SEVEN("seven","7"),
    EIGHT("eight","8"),
    NINE("nine","9"),
    TEN("ten","10"),
    JACK("jack","J"),
    QUEEN("queen","Q"),
    KING("king","K");

    private String number;
    private String symbol;

    CardNumber(String number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}