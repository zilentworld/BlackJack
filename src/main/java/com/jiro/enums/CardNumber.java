package com.jiro.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum CardNumber {

    ACE("A", "ace", 1, 11),
    TWO("2", "two", 2, 2),
    THREE("3", "three", 3, 3),
    FOUR("4", "four", 4, 4),
    FIVE("5", "five", 5, 5),
    SIX("6", "six", 6, 6),
    SEVEN("7", "seven", 7, 7),
    EIGHT("8", "eight", 8, 8),
    NINE("9", "nine", 9, 9),
    TEN("10", "ten", 10, 10),
    JACK("J", "jack", 10, 10),
    QUEEN("Q", "queen", 10, 10),
    KING("K", "king", 10, 10);

    private String number;
    private String symbol;
    private int hardValue;
    private int softValue;

    CardNumber(String symbol, String number, int hardValue, int softValue) {
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

    private static final Map<String, CardNumber> map;
    static {
        map = new HashMap();
        for (CardNumber v : CardNumber.values()) {
            map.put(v.symbol, v);
        }
    }

    public static CardNumber findBySymbol(String symbol) {
        return map.get(symbol);
    }
}