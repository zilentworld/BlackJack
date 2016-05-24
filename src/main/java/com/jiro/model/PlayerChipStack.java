package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/23/16.
 */
@Entity
@Table(name = "player_chip_stack")
public class PlayerChipStack implements Serializable {

    @Id
    @Column(name = "player_chip_stack_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerChipStackId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "total_chip_amount")
    private int totalChipAmount;

    @ManyToOne
    @JoinColumn(name = "chip_id")
    private Chip chip;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getTotalChipAmount() {
        return totalChipAmount;
    }

    public void setTotalChipAmount(int totalChipAmount) {
        this.totalChipAmount = totalChipAmount;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public long getPlayerChipStackId() {
        return playerChipStackId;
    }

    public void setPlayerChipStackId(long playerChipStackId) {
        this.playerChipStackId = playerChipStackId;
    }
}
