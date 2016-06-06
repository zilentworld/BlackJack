package com.jiro.service.impl;

import com.jiro.dao.RoundPlayerCardsDao;
import com.jiro.model.*;
import com.jiro.service.RoundPlayerCardHandService;
import com.jiro.service.RoundPlayerCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 6/6/16.
 */
@Service
public class RoundPlayerCardsServiceImpl implements RoundPlayerCardsService {


    @Qualifier("roundPlayerCardsDao")
    @Autowired
    private RoundPlayerCardsDao roundPlayerCardsDao;
    @Qualifier("roundPlayerCardHandServiceImpl")
    @Autowired
    private RoundPlayerCardHandService roundPlayerCardHandService;


    @Override
    public void savePlayerCards(RoundPlayerCardHand roundPlayerCardHand) {
        CardHand cardHand = roundPlayerCardHand.getCardHand();
        cardHand.getCards().forEach(card -> roundPlayerCardsDao.save(new RoundPlayerCards(roundPlayerCardHand, card.toDbFormat())));

        roundPlayerCardHand.setCardHandCount(cardHand.getHandValue());
        roundPlayerCardHandService.saveRoundPlayerCardHand(roundPlayerCardHand);
    }

    @Override
    public void addPlayerCard(RoundPlayerCardHand roundPlayerCardHand, Card card) {
        roundPlayerCardsDao.save(new RoundPlayerCards(roundPlayerCardHand, card.toDbFormat()));

        roundPlayerCardHand.setCardHandCount(roundPlayerCardHand.getCardHand().getHandValue());
        roundPlayerCardHandService.saveRoundPlayerCardHand(roundPlayerCardHand);
    }
}
