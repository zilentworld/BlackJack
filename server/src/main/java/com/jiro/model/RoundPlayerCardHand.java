package com.jiro.model;

import com.jiro.enums.CardHandStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "card_hand_count")
    private int cardHandCount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roundPlayerCardHand")
    private List<RoundPlayerCards> roundPlayerCardsList;

    @Transient
    private CardHand cardHand;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_hand_status")
    private CardHandStatus cardHandStatus;

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

//    public String getCardHandStatus() {
//        return cardHandStatus;
//    }
//
//    public void setCardHandStatus(String cardHandStatus) {
//        this.cardHandStatus = cardHandStatus;
//    }

    public CardHand getCardHand() {
        if (cardHand == null) {
            if (roundPlayerCardsList == null || roundPlayerCardsList.size() <= 0) {
                System.out.println("round player null or 0");
                cardHand = new CardHand();
            }
            else {
                System.out.println("cards list");
                List<Card> cards = new ArrayList<>();
                roundPlayerCardsList.forEach(roundPlayerCards -> cards.add(new Card(roundPlayerCards.getCardSymbol())));
                cardHand = new CardHand(cards);
            }
        }
        return cardHand;
    }

    public void setCardHand(CardHand cardHand) {
        this.cardHand = cardHand;
    }

    public CardHandStatus getCardHandStatus() {
        return cardHandStatus;
    }

    public void setCardHandStatus(CardHandStatus cardHandStatus) {
        this.cardHandStatus = cardHandStatus;
    }

    public List<RoundPlayerCards> getRoundPlayerCardsList() {
        return roundPlayerCardsList;
    }

    public void setRoundPlayerCardsList(List<RoundPlayerCards> roundPlayerCardsList) {
        this.roundPlayerCardsList = roundPlayerCardsList;
    }

    public int getCardHandCount() {
        if(cardHandCount == 0 && cardHand != null && cardHand.getCards().size() > 0) {
            cardHandCount = cardHand.getHandValue();
        }
        return cardHandCount;
    }

    public void setCardHandCount(int cardHandCount) {
        this.cardHandCount = cardHandCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append("Player Name: " + roundPlayer.getPlayer().getUsername());
        sb.append("RoundCardHandId:" + roundCardHandId + "\n");
        sb.append("CardHand: " + getCardHand().toString() + "\n");
        sb.append("Card Value: " + getCardHandCount() + "\n");
        sb.append("Bet amount: " + betAmount + "\n");
        sb.append("CardHandStatus: " + cardHandStatus);

        return sb.toString();
    }

    public RoundPlayerCardHand() {
    }

    public RoundPlayerCardHand(RoundPlayer roundPlayer, int betAmount) {
        this.roundPlayer = roundPlayer;
        this.betAmount = betAmount;
        this.cardHandStatus = CardHandStatus.PLAYING;
    }
}
