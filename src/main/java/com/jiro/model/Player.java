package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "player")
//@AttributeOverrides({
//        @AttributeOverride(name = "username", column = @Column(name="player_username")),
//        @AttributeOverride(name = "password", column = @Column(name="player_password"))
//})
public class Player
//        extends Account
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long playerId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private List<PlayerHand> playerHandList;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerChipStack> playerChipStackList;*/

    @Column(name = "total_chip_amount")
    private int totalChipAmount;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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

    /*public List<PlayerChipStack> getPlayerChipStackList() {
        return playerChipStackList;
    }

    public void setPlayerChipStackList(List<PlayerChipStack> playerChipStackList) {
        this.playerChipStackList = playerChipStackList;
    }*/

    public List<PlayerHand> getPlayerHandList() {
        return playerHandList;
    }

    public void setPlayerHandList(List<PlayerHand> playerHandList) {
        this.playerHandList = playerHandList;
    }

    public int getTotalChipAmount() {
        return totalChipAmount;
    }

    public void setTotalChipAmount(int totalChipAmount) {
        this.totalChipAmount = totalChipAmount;
    }

    public Player() {
    }

    public Player(long playerId) {
        this.playerId = playerId;
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player ID:"+ playerId + "\n" +
               "Username:" + username + "\n" +
               "Password:" + password;
    }
}
