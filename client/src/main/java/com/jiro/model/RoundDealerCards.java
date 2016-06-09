package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_dealer_cards")
public class RoundDealerCards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "round_card_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundCardListId;

    @ManyToOne
    @JoinColumn(name = "roundId")
    private Round round;

//    @Column(name = "roundId")
//    private long roundId;

    @Column(name = "dealer_id")
    private long dealerId;

    @Column(name = "card_symbol")
    private String cardSymbol;

    public long getRoundCardListId() {
        return roundCardListId;
    }

    public void setRoundCardListId(long roundCardListId) {
        this.roundCardListId = roundCardListId;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

//    public long getRoundId() {
//        return roundId;
//    }
//
//    public void setRoundId(long roundId) {
//        this.roundId = roundId;
//    }

    public String getCardSymbol() {
        return cardSymbol;
    }

    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public long getDealerId() {
        return dealerId;
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

    public RoundDealerCards() {}

    public RoundDealerCards(Round round, String cardSymbol) {
        this.round = round;
        dealerId = round.getDealer().getId();
        this.cardSymbol = cardSymbol;
    }

    public Card getAsCard() {
        Card c = new Card(cardSymbol);
        System.out.println("roundDealerCards:"+c.toString());
        return c;
    }

}
