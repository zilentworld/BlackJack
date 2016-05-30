package com.jiro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
@Entity
@Table(name = "round")
public class Round {

    @Id
    @Column(name = "round_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Account dealer;

    @Transient
    private CardHand dealerHand;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "round")
    private List<RoundPlayer> roundPlayerList;

    public long getRoundId() {
        return roundId;
    }

    public void setRoundId(long roundId) {
        this.roundId = roundId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<RoundPlayer> getRoundPlayerList() {
        if(roundPlayerList == null)
            roundPlayerList = new ArrayList<>();
        return roundPlayerList;
    }

    public Account getDealer() {
        return dealer;
    }

    public void setDealer(Account dealer) {
        this.dealer = dealer;
    }

    public void setRoundPlayerList(List<RoundPlayer> roundPlayerList) {
        this.roundPlayerList = roundPlayerList;
    }

    public CardHand getDealerHand() {
        if(dealerHand == null)
            dealerHand = new CardHand();

        return dealerHand;
    }

    public void setDealerHand(CardHand dealerHand) {
        this.dealerHand = dealerHand;
    }

    public Round() {
    }

    public Round(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dealer: " + dealerHand.toString() + "\n");
        sb.append("Players:" + "\n");
        roundPlayerList.forEach(roundPlayer -> sb.append(roundPlayer.toString() + "\n"));

        return sb.toString();
    }
}
