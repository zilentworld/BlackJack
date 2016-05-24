package com.jiro.model;

import com.jiro.enums.Chip;

import java.util.Map;

/**
 * Created by dev-pc on 5/23/16.
 */
public class ChipBank {

    private Player player;
    private int chipCount;
    private Map<Chip, Integer> chipDeck;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }

    public Map<Chip, Integer> getChipDeck() {
        return chipDeck;
    }

    public void setChipDeck(Map<Chip, Integer> chipDeck) {
        this.chipDeck = chipDeck;
    }
}
