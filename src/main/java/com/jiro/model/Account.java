package com.jiro.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/25/16.
 */
@MappedSuperclass
public class Account implements Serializable{

    private String username;
    private String password;

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
}
