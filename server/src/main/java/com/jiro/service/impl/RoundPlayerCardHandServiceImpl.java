package com.jiro.service.impl;

import com.jiro.dao.RoundPlayerCardHandDao;
import com.jiro.model.*;
import com.jiro.service.AccountService;
import com.jiro.service.CardHandService;
import com.jiro.service.GameDeckService;
import com.jiro.service.RoundPlayerCardHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

/**
 * Created by dev-pc on 5/31/16.
 */
@Service
public class RoundPlayerCardHandServiceImpl implements RoundPlayerCardHandService {

    @Autowired
    private RoundPlayerCardHandDao roundPlayerCardHandDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CardHandService cardHandService;
    @Autowired
    private GameDeckService gameDeckService;


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
        Account player = r.getRoundPlayer().getPlayer();
        GameDeck gameDeck = r.getRoundPlayer().getRound().getGame().getGameDeck();
        Deck deck = new Deck(gameDeck);
        int betAmount = r.getBetAmount();
        if(accountService.canMakeBet(player, betAmount)) {
            accountService.deductChips(player, betAmount);
            r.setBetAmount(betAmount * 2);
            cardHandService.addCard(r.getCardHand(), deck, true);
            gameDeckService.updateGameDeck(gameDeck, deck);
        }
    }

    @Override
    public RoundPlayerCardHand newCardHand(RoundPlayer roundPlayer, int betAmount) {
        return roundPlayerCardHandDao.save(new RoundPlayerCardHand(roundPlayer, betAmount));
    }
}
