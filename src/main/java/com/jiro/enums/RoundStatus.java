package com.jiro.enums;

/**
 * Created by dev-pc on 5/30/16.
 */
public enum RoundStatus {

    WAITING("waiting"),
    LOST("lost"),
    WON("won");

    private String status;

    RoundStatus(String status) {
        this.status = status;
    }
}
