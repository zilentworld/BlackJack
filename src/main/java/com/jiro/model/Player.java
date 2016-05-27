package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "player")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name="playerId"))
})
public class Player
        extends Account
        implements Serializable {

    @Column(name = "total_chip_amount")
    private int totalChipAmount;

    public int getTotalChipAmount() {
        return totalChipAmount;
    }

    public void setTotalChipAmount(int totalChipAmount) {
        this.totalChipAmount = totalChipAmount;
    }

    public Player() {}

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public Player(long playerId) {

    }

    public Player(String username, String password) {
        setUsername(username);
        setPassword(password);
//        this.username = username;
//        this.password = password;
    }

    @Override
    public String toString() {
//        return "Player ID:"+ playerId + "\n" +
//               "Username:" + username + "\n" +
//               "Password:" + password;

        return "Player ID:"+ getId() + "\n" +
               "Username:" + getUsername() + "\n" +
               "Password:" + getPassword();
    }
}
