package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
public class CardHand {

    private List<Card> cardHand;

    public List<Card> getCardHand() {
        if(cardHand == null) {
            cardHand = new ArrayList<>();
        }
        return cardHand;
    }

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    public CardHand() {
    }

    public CardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }
}
