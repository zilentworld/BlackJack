package com.jiro.service;

import com.jiro.model.Card;
import com.jiro.model.CardHand;
import com.jiro.model.Deck;
import com.jiro.model.RoundDealerCards;

import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface CardHandService {

    Card addCard(CardHand cardHand, Deck deck, boolean isVisible);

}
