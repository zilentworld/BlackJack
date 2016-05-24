package com.jiro.service;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;
import com.jiro.model.Card;
import com.jiro.model.Deck;

import java.util.Set;

public interface DeckService {

    void populateDeck(Deck deck);

    Set<Card> populateSuit(CardSuit cardSuit, Set<CardNumber> cardNumberSet);

    Set<Card> populateNumber(CardNumber cardNumber, Set<CardSuit> cardSuitSet);

    void shuffleDeck(Deck deck);

    void removeCard(Deck deck, int index);

    void addCard(Deck deck, Card card);

    Card getCard(Deck deck);

}
