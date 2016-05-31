package com.jiro.model;

import com.jiro.enums.RoundStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "round_player")
public class RoundPlayer {

    @Id
    @Column(name = "round_player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roundListId;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Account player;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roundPlayer")
    private List<RoundPlayerCardHand> roundPlayerCardHandList;

    @Transient
    private RoundStatus roundStatus;

    public long getRoundListId() {
        return roundListId;
    }

    public void setRoundListId(long roundListId) {
        this.roundListId = roundListId;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Account getPlayer() {
        return player;
    }

    public void setPlayer(Account player) {
        this.player = player;
    }

    public List<RoundPlayerCardHand> getRoundPlayerCardHandList() {
        if (roundPlayerCardHandList == null) {
            roundPlayerCardHandList = new ArrayList<>();
        }

        return roundPlayerCardHandList;
    }

    public void setRoundPlayerCardHandList(List<RoundPlayerCardHand> roundPlayerCardHandList) {
        this.roundPlayerCardHandList = roundPlayerCardHandList;
    }

    public RoundPlayer() {
    }

    public RoundPlayer(Account player) {
        this.player = player;
    }

    public RoundPlayer(Round round, Account player, int initialBet) {
        this.round = round;
        this.player = player;

        roundPlayerCardHandList = new ArrayList<>();
        roundPlayerCardHandList.add(new RoundPlayerCardHand(this, initialBet));
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(RoundStatus roundStatus) {
        this.roundStatus = roundStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player Name:" + player.getUsername() + "\n");
        roundPlayerCardHandList.forEach(roundPlayerCardHand -> sb.append(roundPlayerCardHand.toString()));

        return sb.toString();
    }
}
