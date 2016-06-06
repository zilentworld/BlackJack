package com.jiro.service;

import com.jiro.model.Card;
import com.jiro.model.RoundPlayerCardHand;

/**
 * Created by dev-pc on 6/6/16.
 */
public interface RoundPlayerCardsService {

    void savePlayerCards(RoundPlayerCardHand roundPlayerCardHand);

    void addPlayerCard(RoundPlayerCardHand roundPlayerCardHand, Card card);

}
