package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

public class DealerHand {

    private Dealer dealer;
    private List<Card> cardHand;

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public List<Card> getCardHand() {
        if(cardHand == null) {
            cardHand = new ArrayList<>();
        }
        return cardHand;
    }

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cardHand.forEach(card -> sb.append(card + "\n"));
        return sb.toString();
    }
}
