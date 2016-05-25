package com.jiro.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    @OneToOne(mappedBy="game", cascade=CascadeType.ALL)
    private Room room;

    @Transient
    private Deck playDeck;

    @Transient
    private Deck discardDeck;

    @Transient
    private List<Player> playerList;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

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

    public Game() {}

    public Game(Room room, Deck playDeck) {
        this.room = room;
        this.playDeck = playDeck;
        this.discardDeck = new Deck();
    }
}
