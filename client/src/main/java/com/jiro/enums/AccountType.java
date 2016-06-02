package com.jiro.enums;

/**
 * Created by dev-pc on 5/30/16.
 */
public enum AccountType {
    DEALER("dealer"),
    PLAYER("player"),
    ADMIN("admin");

    private String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }
}
