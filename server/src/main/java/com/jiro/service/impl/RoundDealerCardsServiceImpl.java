package com.jiro.service.impl;

import com.jiro.dao.RoundDealerCardsDao;
import com.jiro.model.Card;
import com.jiro.model.CardHand;
import com.jiro.model.Round;
import com.jiro.model.RoundDealerCards;
import com.jiro.service.RoundDealerCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 6/6/16.
 */
@Service
public class RoundDealerCardsServiceImpl implements RoundDealerCardsService {

    @Autowired
    private RoundDealerCardsDao roundDealerCardsDao;

    @Override
    public void saveDealerCards(Round round) {
        CardHand cardHand = round.getDealerHand();
        cardHand.getCards().forEach(card -> roundDealerCardsDao.save(new RoundDealerCards(round, card.toDbFormat())));
    }

    @Override
    public void addDealerCard(Round round, Card card) {
        roundDealerCardsDao.save(new RoundDealerCards(round, card.toDbFormat()));
    }
}
