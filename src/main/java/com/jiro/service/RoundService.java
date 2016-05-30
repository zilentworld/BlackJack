package com.jiro.service;

import com.jiro.model.Account;
import com.jiro.model.Game;
import com.jiro.model.Round;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface RoundService {

    Round createNewRound (long gameId);

    Round createNewRound (Game game);

    void startRound (long roundId);

    void distributeInitialCards(Round round);

    boolean joinRound (Round round, Account player, int initialBet);

    boolean joinRound (long roundId, long playerId, int initialBet);

}
