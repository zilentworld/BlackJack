package com.jiro.service;

import com.jiro.model.CardHand;
import com.jiro.model.Deck;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface CardHandService {

    void addCard(CardHand cardHand, Deck deck, boolean isVisible);
}
