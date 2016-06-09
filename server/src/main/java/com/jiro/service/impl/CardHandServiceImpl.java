package com.jiro.service.impl;

import com.jiro.model.Card;
import com.jiro.model.CardHand;
import com.jiro.model.Deck;
import com.jiro.model.RoundDealerCards;
import com.jiro.service.CardHandService;
import com.jiro.service.RoundDealerCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
@Service
public class CardHandServiceImpl implements CardHandService {

    @Override
    public Card addCard(CardHand cardHand, Deck deck, boolean isVisible) {
        Card c = deck.getCard(isVisible);
        cardHand.getCards().add(c);
        System.out.println("addCard:c:"+c.toString());
        return c;
    }

}