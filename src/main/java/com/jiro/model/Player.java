package com.jiro.model;

/**
 * Created by dev-pc on 5/23/16.
 */
public class Player {

    private long playerId;
    private CardHand cardHand;
    private ChipBank chipBank;
    private int bet;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public ChipBank getChipBank() {
        return chipBank;
    }

    public void setChipBank(ChipBank chipBank) {
        this.chipBank = chipBank;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public CardHand getCardHand() {
        return cardHand;
    }

    public void setCardHand(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    public Player(){}

}
