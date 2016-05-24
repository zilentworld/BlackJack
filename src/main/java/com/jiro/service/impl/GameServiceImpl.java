package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.model.Deck;
import com.jiro.model.Game;
import com.jiro.model.Room;
import com.jiro.service.DeckService;
import com.jiro.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private DeckService deckService;

    @Override
    public Game createNewGame(Room room) {

        Deck deck = new Deck();
        deck.setDeckSize(Constants.DEFAULT_DECK_SIZE);

        if(deckService == null) {
            deckService = new DeckServiceImpl();
        }

        deckService.populateDeck(deck);
        deckService.shuffleDeck(deck);

        Game game = room.getGame();
        if(game == null) {
            game = new Game(room, deck);
        } else {
            game.setPlayDeck(deck);
            game.setDiscardDeck(new Deck());
        }

        return game;
    }

    @Override
    public void newRound(Game game) {

    }
}
