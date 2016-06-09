package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/30/16.
 */
@Entity
@Table(name = "room_player_list")
public class RoomPlayer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "room_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomListId;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Account player;

    public long getRoomListId() {
        return roomListId;
    }

    public void setRoomListId(long roomListId) {
        this.roomListId = roomListId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Account getPlayer() {
        return player;
    }

    public void setPlayer(Account player) {
        this.player = player;
    }

    public RoomPlayer() {}

    public RoomPlayer(Account player) {
        this.player = player;
    }
}
