package com.jiro.model;

import javax.persistence.*;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_player_card_hand")
public class RoundPlayerCardHand {

    @Id
    @Column(name = "roundCardHandId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundCardHandId;

    @ManyToOne
    @JoinColumn(name = "round_player_id")
    private RoundPlayer roundPlayer;

    @Column(name = "bet_amount")
    private int betAmount;

    @Transient
    private CardHand cardHand;

    public long getRoundCardHandId() {
        return roundCardHandId;
    }

    public void setRoundCardHandId(long roundCardHandId) {
        this.roundCardHandId = roundCardHandId;
    }

    public RoundPlayer getRoundPlayer() {
        return roundPlayer;
    }

    public void setRoundPlayer(RoundPlayer roundPlayer) {
        this.roundPlayer = roundPlayer;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public CardHand getCardHand() {
        if(cardHand == null)
            cardHand = new CardHand();
        return cardHand;
    }

    public void setCardHand(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("Player Name: " + roundPlayer.getPlayer().getUsername());
        sb.append("RoundCardHandId:"+ roundCardHandId);
        sb.append("CardHand: " + cardHand.toString() + "\n");
        sb.append("Bet amount: " + betAmount + "\n");

        return sb.toString();
    }

    public RoundPlayerCardHand() {}

    public RoundPlayerCardHand(RoundPlayer roundPlayer, int betAmount) {
        this.roundPlayer = roundPlayer;
        this.betAmount = betAmount;
    }

}
