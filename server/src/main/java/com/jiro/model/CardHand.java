package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
public class CardHand {

    private List<Card> cards;

    public List<Card> getCards() {
        if (cards == null) {
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
        if (cards != null && cards.size() > 0)
            cards.forEach(card -> sb.append(card.toString() + " "));

        return sb.toString();
    }

    public String toDbFormat() {
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for (Card card : cards) {
            sb.append(card.toDbFormat());
            if (a++ < cards.size() - 1)
                sb.append(":");
        }

        return sb.toString();
    }

    public int getSoftValue() {
        int softValue = 0;
        for (Card card : cards) {
            softValue += card.getSoftValue();
        }

        return softValue;
    }

    public int getHardValue() {
        int softValue = 0;
        for (Card card : cards) {
            softValue += card.getHardValue();
        }

        return softValue;
    }

    public int getHandValue() {
        int softValue = getSoftValue();
        int hardValue = getHardValue();
        if(softValue <= 21 && softValue > hardValue) {
            return softValue;
        }
        return hardValue;
    }

}