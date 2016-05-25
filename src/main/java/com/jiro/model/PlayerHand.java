package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/23/16.
 */
public class PlayerHand {

    private Player player;
    private List<Card> cardHand;
    private Bet bet;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cardHand.forEach(card -> sb.append(card + "\n"));
        return sb.toString();
    }
}
