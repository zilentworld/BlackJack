package com.jiro.enums;

import static com.jiro.enums.BlackJackEventType.*;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum BlackJackEvent {

    HIT("hit", PLAYER_EVENT),
    STAND("stand", PLAYER_EVENT),
    DOUBLE("double", PLAYER_EVENT),
    SPLIT("split", PLAYER_EVENT),
    BLACKJACK("blackjack", PLAYER_EVENT),

    DEALER_HIT("dealer_hit", DEALER_EVENT),

    DEALER_BLACKJACK("dealer_blackjack", WIN_EVENT),
    PUSH("push", WIN_EVENT),
    PLAYER_LOSE("player_lose", WIN_EVENT),
    PLAYER_WIN("player_win", WIN_EVENT);

    private String action;
    private BlackJackEventType eventType;

    BlackJackEvent(String action, BlackJackEventType eventType) {
        this.action = action;
        this.eventType = eventType;
    }



}