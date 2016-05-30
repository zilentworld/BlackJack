package com.jiro.model;

import com.jiro.constants.Constants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Account dealer;

    @Transient
    private Deck playDeck;

    @Transient
    private Deck discardDeck;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Round> roundList;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Deck getPlayDeck() {
        if(playDeck == null) {
            playDeck = new Deck(Constants.DEFAULT_DECK_SIZE);
            playDeck.populateDeck();
            playDeck.shuffleDeck();
        }
        return playDeck;
    }

    public void setPlayDeck(Deck playDeck) {
        this.playDeck = playDeck;
    }

    public Deck getDiscardDeck() {
        return discardDeck;
    }

    public void setDiscardDeck(Deck discardDeck) {
        this.discardDeck = discardDeck;
    }

    public List<Round> getRoundList() {
        if(roundList == null) {
            roundList = new ArrayList<>();
        }
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public Account getDealer() {
        return dealer;
    }

    public void setDealer(Account dealer) {
        this.dealer = dealer;
    }

    public Game() {
    }

    public Game(Room room, Deck playDeck) {
        this.room = room;
        this.dealer = room.getDealer();
        this.playDeck = playDeck;
        this.discardDeck = new Deck();
    }
}
