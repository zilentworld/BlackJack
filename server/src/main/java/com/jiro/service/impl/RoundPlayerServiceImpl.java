package com.jiro.service.impl;

import com.jiro.dao.RoundPlayerDao;
import com.jiro.model.Account;
import com.jiro.model.Round;
import com.jiro.model.RoundPlayer;
import com.jiro.service.RoundPlayerCardHandService;
import com.jiro.service.RoundPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 6/1/16.
 */
@Service
public class RoundPlayerServiceImpl implements RoundPlayerService {

    @Autowired
    private RoundPlayerDao roundPlayerDao;
    @Autowired
    private RoundPlayerCardHandService roundPlayerCardHandService;

    @Override
    public RoundPlayer findById(long roundPlayerId) {
        return roundPlayerDao.findOne(roundPlayerId);
    }

    @Override
    public void saveRoundPlayer(RoundPlayer roundPlayer) {
        roundPlayerDao.save(roundPlayer);
    }

    @Override
    public RoundPlayer newRoundPlayer(Round round, Account player, int betAmount) {

        RoundPlayer roundPlayer = new RoundPlayer(round, player);

        roundPlayer.getRoundPlayerCardHandList().add(roundPlayerCardHandService.newCardHand(roundPlayer, betAmount));

        roundPlayerDao.save(roundPlayer);

        return roundPlayer;
    }
}
