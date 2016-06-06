package com.jiro.service;

import com.jiro.model.Account;
import com.jiro.model.Card;
import com.jiro.model.Round;
import com.jiro.model.RoundDealerCards;

/**
 * Created by dev-pc on 6/6/16.
 */
public interface RoundDealerCardsService {

    void saveDealerCards(Round round);

    void addDealerCard(Round round, Card card);

}
