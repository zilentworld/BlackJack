package com.jiro.model;

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
        return cardHand;
    }

    public void setCardHand(List<Card> cardHand) {
        this.cardHand = cardHand;
    }
}
