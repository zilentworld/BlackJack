package com.jiro.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;

    @OneToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @OneToMany

    private List<Player> playerList;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Game game;

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
