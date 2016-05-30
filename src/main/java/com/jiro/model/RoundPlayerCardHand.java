package com.jiro.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_player_card_hand")
public class RoundPlayerCardHand {

    @Id
    @Column(name = "round_card_hand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long round_card_hand_id;

    @ManyToOne
    @JoinColumn(name = "round_player_id")
    private RoundPlayer roundPlayer;

    @Column(name = "bet_amount")
    private int betAmount;

    @Transient
    private CardHand cardHand;

    public long getRound_card_hand_id() {
        return round_card_hand_id;
    }

    public void setRound_card_hand_id(long round_card_hand_id) {
        this.round_card_hand_id = round_card_hand_id;
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
        return cardHand;
    }

    public void setCardHand(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player Name: " + roundPlayer.getPlayer().getUsername());
        sb.append("Bet amount: " + betAmount);
        sb.append("CardHand: " + cardHand.toString());

        return super.toString();
    }

    public RoundPlayerCardHand() {}

    public RoundPlayerCardHand(RoundPlayer roundPlayer, int betAmount) {
        this.roundPlayer = roundPlayer;
        this.betAmount = betAmount;
    }
}
