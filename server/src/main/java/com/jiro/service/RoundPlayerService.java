package com.jiro.service;

import com.jiro.model.Account;
import com.jiro.model.Round;
import com.jiro.model.RoundPlayer;

/**
 * Created by dev-pc on 6/1/16.
 */
public interface RoundPlayerService {

    RoundPlayer findById(long roundPlayerId);

    void saveRoundPlayer(RoundPlayer roundPlayer);

    RoundPlayer newRoundPlayer(Round round, Account player, int betAmount);

}
