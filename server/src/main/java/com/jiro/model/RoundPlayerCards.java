package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_player_cards")
public class RoundPlayerCards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "round_card_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundCardListId;

//    @ManyToOne
//    @JoinColumn(name = "round_id")
//    private Round round;

//    @Column(name = "round_card_hand_id")
//    private long round_card_hand_id;

    @ManyToOne
    @JoinColumn(name = "round_card_hand_id")
    private RoundPlayerCardHand roundPlayerCardHand;

    @Column(name = "card_symbol")
    private String cardSymbol;

    @Column(name = "round_player_id")
    private long roundPlayerId;

    public long getRoundCardListId() {
        return roundCardListId;
    }

    public void setRoundCardListId(long roundCardListId) {
        this.roundCardListId = roundCardListId;
    }

//    public Round getRound() {
//        return round;
//    }
//
//    public void setRound(Round round) {
//        this.round = round;
//    }


    public RoundPlayerCards() {}

    public RoundPlayerCards(RoundPlayerCardHand roundPlayerCardHand, String cardSymbol) {
        this.roundPlayerCardHand = roundPlayerCardHand;
        this.roundPlayerId = roundPlayerCardHand.getRoundPlayer().getPlayer().getId();
        this.cardSymbol = cardSymbol;
    }

//    public long getRound_card_hand_id() {
//        return round_card_hand_id;
//    }
//
//    public void setRound_card_hand_id(long round_card_hand_id) {
//        this.round_card_hand_id = round_card_hand_id;
//    }


    public long getRoundPlayerId() {
        return roundPlayerId;
    }

    public void setRoundPlayerId(long roundPlayerId) {
        this.roundPlayerId = roundPlayerId;
    }

    public RoundPlayerCardHand getRoundPlayerCardHand() {
        return roundPlayerCardHand;
    }

    public void setRoundPlayerCardHand(RoundPlayerCardHand roundPlayerCardHand) {
        this.roundPlayerCardHand = roundPlayerCardHand;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }
}
