package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "room")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Account dealer;

    @Column(name = "round_count")
    private int roundCount;

    @Column(name = "create_time", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "leave_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date destroyTime;

    @Transient
    private List<RoomPlayer> roomPlayersList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> gameList;

    public Account getDealer() {
        return dealer;
    }

    public void setDealer(Account dealer) {
        this.dealer = dealer;
    }

    public List<RoomPlayer> getRoomPlayersList() {
        if (roomPlayersList == null) {
            roomPlayersList = new ArrayList<>();
        }
        return roomPlayersList;
    }

    public void setRoomPlayersList(List<RoomPlayer> roomPlayersList) {
        this.roomPlayersList = roomPlayersList;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public List<Game> getGameList() {
        if(gameList == null)
            gameList = new ArrayList<>();
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Date destroyTime) {
        this.destroyTime = destroyTime;
    }

    public void incRoundCount() {
        this.roundCount++;
    }
}
