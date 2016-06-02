package com.jiro.service;

import com.jiro.model.Deck;
import com.jiro.model.GameDeck;

/**
 * Created by dev-pc on 5/31/16.
 */
public interface GameDeckService {

    GameDeck saveNewDeck(Deck deck);

    void saveGameDeck(GameDeck gameDeck);

    Deck getDeck(long gameDeckId);

    GameDeck getGameDeck(long gameDeckId);

    void updateGameDeck(GameDeck gameDeck, Deck deck);
}
