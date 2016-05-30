package com.jiro.model;

import javax.persistence.*;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_player_cards")
public class RoundPlayerCards {

    @Id
    @Column(name = "round_card_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundCardListId;

//    @ManyToOne
//    @JoinColumn(name = "round_id")
//    private Round round;

    @Column(name = "round_card_hand_id")
    private long round_card_hand_id;

    @Column(name = "card_symbol")
    private String cardSymbol;

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


    public long getRound_card_hand_id() {
        return round_card_hand_id;
    }

    public void setRound_card_hand_id(long round_card_hand_id) {
        this.round_card_hand_id = round_card_hand_id;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }
}
