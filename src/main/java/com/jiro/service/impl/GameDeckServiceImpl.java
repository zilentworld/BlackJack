package com.jiro.service.impl;

import com.jiro.dao.GameDeckDao;
import com.jiro.model.Deck;
import com.jiro.model.GameDeck;
import com.jiro.service.GameDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/31/16.
 */
@Service
public class GameDeckServiceImpl implements GameDeckService {

    @Autowired
    private GameDeckDao gameDeckDao;

    @Override
    public GameDeck saveNewDeck(Deck deck) {
        GameDeck gameDeck = new GameDeck(deck);
        gameDeckDao.save(gameDeck);

        return gameDeck;
    }

    @Override
    public void saveGameDeck(GameDeck gameDeck) {
        gameDeckDao.save(gameDeck);
    }

    @Override
    public Deck getDeck(long gameDeckId) {
        return new Deck(gameDeckDao.findOne(gameDeckId));
    }

    @Override
    public GameDeck getGameDeck(long gameDeckId) {
        return gameDeckDao.findOne(gameDeckId);
    }

    @Override
    public void updateGameDeck(GameDeck gameDeck, Deck deck) {
        gameDeck.parseDeck(deck);
        gameDeckDao.save(gameDeck);
    }
}
