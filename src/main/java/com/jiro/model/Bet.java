package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dev-pc on 5/24/16.
 */
@Entity
@Table(name = "bet")
public class Bet implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long betId;

    @Column(name = "bet_amount")
    private int betAmount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bet", fetch = FetchType.LAZY)
    private List<BetChipStack> betChipStackList;

    public long getBetId() {
        return betId;
    }

    public void setBetId(long betId) {
        this.betId = betId;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public List<BetChipStack> getBetChipStackList() {
        return betChipStackList;
    }

    public void setBetChipStackList(List<BetChipStack> betChipStackList) {
        this.betChipStackList = betChipStackList;
    }
}
