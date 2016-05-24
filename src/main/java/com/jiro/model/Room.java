package com.jiro.model;

import com.jiro.enums.Chip;

import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 5/23/16.
 */
public class Room {

    private long roomId;
    private Deck deck;
    private Deck discardDeck;
    private Dealer dealer;
    private int bet;
    private Map<Chip, Integer> chipBets;
    private List<Player> playerList;

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDiscardDeck() {
        return discardDeck;
    }

    public void setDiscardDeck(Deck discardDeck) {
        this.discardDeck = discardDeck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Map<Chip, Integer> getChipBets() {
        return chipBets;
    }

    public void setChipBets(Map<Chip, Integer> chipBets) {
        this.chipBets = chipBets;
    }
}
