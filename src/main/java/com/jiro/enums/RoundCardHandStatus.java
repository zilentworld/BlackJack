package com.jiro.enums;

/**
 * Created by dev-pc on 5/30/16.
 */
public enum RoundCardHandStatus {

    WAITING("waiting"),
    PLAYING("playing"),
    LOST("lost"),
    WON("won");

    private String status;

    RoundCardHandStatus(String status) {
        this.status = status;
    }
}
