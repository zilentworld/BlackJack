package com.jiro.service.impl;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;
import com.jiro.model.Card;
import com.jiro.model.Deck;
import com.jiro.service.DeckService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeckServiceImpl implements DeckService {

    public void populateDeck(Deck deck) {
        Set<CardNumber> cardNumberSet = EnumSet.allOf(CardNumber.class);
        Set<CardSuit> cardSuitSet = EnumSet.allOf(CardSuit.class);
        for (int ctr = deck.getDeckSize(); ctr > 0; ctr--) {
            cardSuitSet.forEach(cardSuit ->
                    cardNumberSet.forEach(cardNumber ->
                            deck.getCardList().add(new Card(cardNumber, cardSuit))
                    )
            );
        }
    }

    public Set<Card> populateSuit(CardSuit cardSuit, Set<CardNumber> cardNumberSet) {
        Set<Card> cardSet = new HashSet<>();
        cardNumberSet.forEach(cardNumber -> cardSet.add(new Card(cardNumber, cardSuit)));

        return cardSet;
    }

    public Set<Card> populateNumber(CardNumber cardNumber, Set<CardSuit> cardSuitSet) {
        Set<Card> cardSet = new HashSet<>();
        cardSuitSet.forEach(cardSuit -> cardSet.add(new Card(cardNumber, cardSuit)));

        return cardSet;
    }

    public void shuffleDeck (Deck deck) {
        long seed = System.nanoTime();
        Collections.shuffle(deck.getCardList(), new Random(seed));
    }

    public void removeCard (Deck deck, int index) {
        deck.getCardList().remove(index);
    }

    public void addCard (Deck deck, Card card) {
        deck.getCardList().add(card);
    }

    public Card getCard (Deck deck) {
        LinkedList<Card> cardList = (LinkedList<Card>) deck.getCardList();
        return cardList.pop();
    }

}
