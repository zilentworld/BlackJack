package com.jiro.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dev-pc on 5/24/16.
 */
@Entity
@Table(name = "chip")
public class Chip {

    @Id
    @Column(name = "chip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chipId;

    @Column(name = "chip_desc")
    private String chipDesc;

    @Column(name = "chip_amount")
    private int chipAmount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chip", fetch = FetchType.LAZY)
    private List<BetChipStack> betChipStackList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chip", fetch = FetchType.LAZY)
    private List<PlayerChipStack> playerChipStackList;


    public long getChipId() {
        return chipId;
    }

    public void setChipId(long chipId) {
        this.chipId = chipId;
    }

    public String getChipDesc() {
        return chipDesc;
    }

    public void setChipDesc(String chipDesc) {
        this.chipDesc = chipDesc;
    }

    public int getChipAmount() {
        return chipAmount;
    }

    public void setChipAmount(int chipAmount) {
        this.chipAmount = chipAmount;
    }
}
