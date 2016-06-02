package com.jiro.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum CardSuit {

    CLUB("C", "club"),
    HEART("H", "heart"),
    SPADE("S", "spade"),
    DIAMOND("D", "diamond");

    private String suit;
    private String symbol;

    CardSuit(String symbol, String suit) {
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

    private static final Map<String, CardSuit> map;
    static {
        map = new HashMap();
        for (CardSuit v : CardSuit.values()) {
            map.put(v.symbol, v);
        }
    }

    public static CardSuit findBySymbol(String symbol) {
        return map.get(symbol);
    }
}
