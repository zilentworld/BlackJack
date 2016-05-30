package com.jiro.model;

import javax.persistence.*;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_dealer_cards")
public class RoundDealerCards {

    @Id
    @Column(name = "round_card_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundCardListId;

//    @ManyToOne
//    @JoinColumn(name = "round_id")
//    private Round round;

    @Column(name = "round_id")
    private long round_id;

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

    public long getRound_id() {
        return round_id;
    }

    public void setRound_id(long round_id) {
        this.round_id = round_id;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }
}
