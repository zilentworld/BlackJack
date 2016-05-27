package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dealer")
//@AttributeOverrides({
//        @AttributeOverride(name = "username", column = @Column(name="player_username")),
//        @AttributeOverride(name = "password", column = @Column(name="player_password"))
//})
public class Dealer
        extends Account
        implements Serializable{

    @Id
    @Column(name = "dealer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dealerId;

//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "password")
//    private String password;

    @Transient
    private DealerHand dealerHand;

    public DealerHand getDealerHand() {
        if(dealerHand == null) {
            dealerHand = new DealerHand();
        }
        return dealerHand;
    }

    public void setDealerHand(DealerHand dealerHand) {
        this.dealerHand = dealerHand;
    }

    public long getDealerId() {
        return dealerId;
    }

    public void setDealerId(long dealerId) {
        this.dealerId = dealerId;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
