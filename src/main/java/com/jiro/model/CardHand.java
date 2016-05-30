package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
public class CardHand {

    private List<Card> cards;

    public List<Card> getCards() {
        if(cards == null) {
            cards = new ArrayList<>();
        }

        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public CardHand() {
    }

    public CardHand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(cards != null && cards.size() > 0)
            cards.forEach(card -> sb.append(card.toString()));

        return sb.toString();
    }
}
