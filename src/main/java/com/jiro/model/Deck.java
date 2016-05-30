package com.jiro.model;

import com.jiro.enums.CardNumber;
import com.jiro.enums.CardSuit;

import java.util.*;

public class Deck {

    private Game game;
    private int deckSize;
    private List<Card> cardList;

    public void populateDeck() {
        cardList = new ArrayList<>();
        Set<CardNumber> cardNumberSet = EnumSet.allOf(CardNumber.class);
        Set<CardSuit> cardSuitSet = EnumSet.allOf(CardSuit.class);
        for (int ctr = deckSize; ctr > 0; ctr--) {
            cardSuitSet.forEach(cardSuit ->
                    cardNumberSet.forEach(cardNumber ->
                            cardList.add(new Card(cardNumber, cardSuit))
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

    public void shuffleDeck() {
        long seed = System.nanoTime();
        Collections.shuffle(cardList, new Random(seed));
    }

    public void removeCard(int index) {
        synchronized (this) {
            cardList.remove(index);
        }
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public Card getCard(boolean isVisible) {
        System.out.println(cardList.size());
        synchronized (this) {
            if(cardList != null) {
                Card card = cardList.get(0);
                cardList.remove(0);
                card.setVisible(isVisible);

                return card;
            }
        }
        return  null;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public List<Card> getCardList() {
        if(cardList == null)
            cardList = new LinkedList<>();

        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cardList.forEach(card -> sb.append(card + "\n"));
        return sb.toString();
    }

    public Deck() {}

    public Deck(int deckSize) {
        this.deckSize = deckSize;
    }
}
