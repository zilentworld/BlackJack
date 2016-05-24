package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/23/16.
 */
public class Deck {

    private int deckSize;
    private List<Card> cardList;

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public List<Card> getCardList() {
        if(cardList == null)
            cardList = new ArrayList<>();

        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
