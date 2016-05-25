package com.jiro.enums;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum CardNumber {
    ACE("ace", "A", 1, 10),
    TWO("two", "2", 2, 2),
    THREE("three", "3", 3, 3),
    FOUR("four", "4", 4, 4),
    FIVE("five", "5", 5, 5),
    SIX("six","6", 6, 6),
    SEVEN("seven","7", 7, 7),
    EIGHT("eight","8", 8, 8),
    NINE("nine","9", 9, 9),
    TEN("ten","10", 10, 10),
    JACK("jack","J", 10, 10),
    QUEEN("queen","Q", 10, 10),
    KING("king","K", 10, 10);

    private String number;
    private String symbol;
    private int hardValue;
    private int softValue;

    CardNumber(String number, String symbol, int hardValue, int softValue) {
        this.number = number;
        this.symbol = symbol;
        this.hardValue = hardValue;
        this.softValue = softValue;
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