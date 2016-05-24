package com.jiro.model;

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
}
