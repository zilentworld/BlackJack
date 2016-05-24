package com.jiro.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private Game game;
    private int deckSize;
    private List<Card> cardList;

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
            cardList = new ArrayList<>();

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
}
