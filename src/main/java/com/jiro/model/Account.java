package com.jiro.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by dev-pc on 5/25/16.
 */
@javax.persistence.TableGenerator(
        name="account_sequence",
        table="account_sequence",
        pkColumnName = "account_id"
)
@MappedSuperclass
public class Account implements Serializable{

    private long id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "account_sequence")
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
}
