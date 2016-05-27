package com.jiro.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dealer")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "dealerId"))
})
public class Dealer
        extends Account
        implements Serializable {

    public Dealer() {
    }

    public Dealer(String username, String password) {
        setUsername(username);
        setPassword(password);
//        this.username = username;
//        this.password = password;
    }

}
