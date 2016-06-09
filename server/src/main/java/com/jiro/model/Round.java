package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
@Entity
@Table(name = "round")
public class Round implements Serializable {
    private static final long serialVersionUID = 1L;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "round")
    private List<RoundPlayer> roundPlayerList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "round")
    private List<RoundDealerCards> roundDealerCardsList;

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
        if (roundPlayerList == null)
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
        if (dealerHand == null) {
            if (roundDealerCardsList.size() > 0) {
                List<Card> cards = new ArrayList<>();
                roundDealerCardsList.forEach(roundDealerCards -> cards.add(roundDealerCards.getAsCard()));
                dealerHand = new CardHand(cards);
                System.out.println("size > 0");
            } else {
                dealerHand = new CardHand();
                System.out.println("else");
            }
        }
        System.out.println("dealerHand:"+dealerHand.toString());
        return dealerHand;
    }

    public void setDealerHand(CardHand dealerHand) {
        this.dealerHand = dealerHand;
    }

    public List<RoundDealerCards> getRoundDealerCardsList() {
        return roundDealerCardsList;
    }

    public void setRoundDealerCardsList(List<RoundDealerCards> roundDealerCardsList) {
        this.roundDealerCardsList = roundDealerCardsList;
    }

    public Round() {
    }

    public Round(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dealer: " + getDealerHand().toString() + "\n");
        sb.append("Dealer Card Value: " + getDealerHand().getHandValue() + "\n");
        sb.append("\n");
        sb.append("Players:" + roundPlayerList.size() + "\n");
        roundPlayerList.forEach(roundPlayer -> sb.append(roundPlayer.toString() + "\n"));

        return sb.toString();
    }
}
