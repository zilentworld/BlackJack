package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dealer")
@AttributeOverrides({
        @AttributeOverride(name = "username", column = @Column(name="player_username")),
        @AttributeOverride(name = "password", column = @Column(name="player_password"))
})
public class Dealer extends Account implements Serializable{

    @Id
    @Column(name = "dealer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dealerId;

//    @Column(name = "dealer_username")
//    private String dealerUsername;
//
//    @Column(name = "dealer_password")
//    private String dealerPassword;

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

//    public String getDealerUsername() {
//        return dealerUsername;
//    }
//
//    public void setDealerUsername(String dealerUsername) {
//        this.dealerUsername = dealerUsername;
//    }
//
//    public String getDealerPassword() {
//        return dealerPassword;
//    }
//
//    public void setDealerPassword(String dealerPassword) {
//        this.dealerPassword = dealerPassword;
//    }
}
