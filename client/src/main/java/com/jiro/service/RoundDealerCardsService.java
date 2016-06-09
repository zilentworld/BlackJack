package com.jiro.service;

import com.jiro.model.Card;
import com.jiro.model.Round;

/**
 * Created by dev-pc on 6/6/16.
 */
public interface RoundDealerCardsService {

    void saveDealerCards(Round round);

    void addDealerCard(Round round, Card card);

}
