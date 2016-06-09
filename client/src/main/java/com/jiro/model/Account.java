package com.jiro.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dev-pc on 5/25/16.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "total_chips")
    private int totalChips;

    @Column(name = "is_player")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPlayer;

    @Column(name = "is_dealer")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDealer;

    @Column(name = "is_admin")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAdmin;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Room> roomList;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Round> roundList;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> gameList;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RoomPlayer> roomPlayersList;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RoundPlayer> roundPlayerList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalChips() {
        return totalChips;
    }

    public void setTotalChips(int totalChips) {
        this.totalChips = totalChips;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<RoundPlayer> getRoundPlayerList() {
        return roundPlayerList;
    }

    public void setRoundPlayerList(List<RoundPlayer> roundPlayerList) {
        this.roundPlayerList = roundPlayerList;
    }

    public List<RoomPlayer> getRoomPlayersList() {
        return roomPlayersList;
    }

    public void setRoomPlayersList(List<RoomPlayer> roomPlayersList) {
        this.roomPlayersList = roomPlayersList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }



    public Account() {
    }

    public Account(long id) {
        this.id = id;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Account: username:"+ username + ", password:"+ password;
    }
}
