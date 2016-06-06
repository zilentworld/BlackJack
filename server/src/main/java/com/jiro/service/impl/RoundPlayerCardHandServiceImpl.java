package com.jiro.service.impl;

import com.jiro.dao.RoundPlayerCardHandDao;
import com.jiro.dao.RoundPlayerCardsDao;
import com.jiro.enums.CardHandStatus;
import com.jiro.model.*;
import com.jiro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Autowired
    private RoundPlayerCardsService roundPlayerCardsService;


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
        RoundPlayer rp = r.getRoundPlayer();
        Account player = rp.getPlayer();
        GameDeck gameDeck = rp.getRound().getGame().getGameDeck();
        Deck deck = new Deck(gameDeck);
        int betAmount = r.getBetAmount();

        if (accountService.canMakeBet(player, betAmount)) {
            accountService.deductChips(player, betAmount);
            r.setBetAmount(betAmount * 2);
            Card newCard = cardHandService.addCard(r.getCardHand(), deck, true);
            roundPlayerCardsService.addPlayerCard(r, newCard);
            gameDeckService.updateGameDeck(gameDeck, deck);
        }

        updateCardHandStatus(r);
    }

    @Override
    public void playHit(long roundPlayerCardHandId) {
        RoundPlayerCardHand r = findById(roundPlayerCardHandId);
        RoundPlayer rp = r.getRoundPlayer();
        GameDeck gameDeck = rp.getRound().getGame().getGameDeck();
        Deck deck = new Deck(gameDeck);

        Card newCard = cardHandService.addCard(r.getCardHand(), deck, true);
        roundPlayerCardsService.addPlayerCard(r, newCard);
        gameDeckService.updateGameDeck(gameDeck, deck);

        updateCardHandStatus(r);
    }

    @Override
    public void playStand(long roundPlayerCardHandId) {
        RoundPlayerCardHand r = findById(roundPlayerCardHandId);
        r.setCardHandStatus(CardHandStatus.WAITING);
    }

    @Override
    public RoundPlayerCardHand newCardHand(RoundPlayer roundPlayer, int betAmount) {
        return roundPlayerCardHandDao.save(new RoundPlayerCardHand(roundPlayer, betAmount));
    }

    @Override
    public void updateCardHandStatus(RoundPlayerCardHand roundPlayerCardHand) {
        int cardTotal = roundPlayerCardHand.getCardHandCount();
        if(cardTotal < 21)
            roundPlayerCardHand.setCardHandStatus(CardHandStatus.PLAYING);
        else if(cardTotal == 21 && roundPlayerCardHand.getCardHand().getCards().size() == 2)
            roundPlayerCardHand.setCardHandStatus(CardHandStatus.BLACKJACK);
        else
            roundPlayerCardHand.setCardHandStatus(CardHandStatus.LOST);

        roundPlayerCardHandDao.save(roundPlayerCardHand);
    }
}
