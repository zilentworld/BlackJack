package com.jiro.service.impl;

import com.jiro.model.CardHand;
import com.jiro.model.Deck;
import com.jiro.service.CardHandService;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/30/16.
 */
@Service
public class CardHandServiceImpl implements CardHandService {

    @Override
    public void addCard(CardHand cardHand, Deck deck, boolean isVisible) {
        cardHand.getCards().add(deck.getCard(isVisible));
        System.out.println("addCard:"+cardHand.toString());
    }
}
