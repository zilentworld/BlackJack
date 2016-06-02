package com.jiro.enums;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum BlackJackEventType {

    PLAYER_EVENT("player_event"),
    DEALER_EVENT("dealer_event"),
    WIN_EVENT("win_event");

    private String eventType;

    BlackJackEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
