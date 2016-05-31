package com.jiro.service.impl;

import com.jiro.dao.RoundPlayerCardHandDao;
import com.jiro.model.RoundPlayerCardHand;
import com.jiro.service.AccountService;
import com.jiro.service.RoundPlayerCardHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/31/16.
 */
@Service
public class RoundPlayerCardHandServiceImpl implements RoundPlayerCardHandService {

    @Autowired
    private RoundPlayerCardHandDao roundPlayerCardHandDao;
    @Autowired
    private AccountService accountService;


    @Override
    public void saveRoundPlayerCardHand(RoundPlayerCardHand roundPlayerCardHand) {
        roundPlayerCardHandDao.save(roundPlayerCardHand);
    }

    @Override
    public RoundPlayerCardHand findById(long roundPlayerCardHandId) {
        return roundPlayerCardHandDao.findOne(roundPlayerCardHandId);
    }

    @Override
    public void playDouble(long roundPlayerCardHandId) {
        RoundPlayerCardHand r = findById(roundPlayerCardHandId);
        if(accountService.canMakeBet(r.getRoundPlayer().getPlayer(), r.getBetAmount())) {
            //TODO
        }
    }
}
