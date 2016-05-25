package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.model.*;
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

        if (deckService == null) {
            deckService = new DeckServiceImpl();
        }

        deckService.populateDeck(deck);
        deckService.shuffleDeck(deck);

        Game game = room.getGame();
        if (game == null) {
            game = new Game(room, deck);
        } else {
            game.setPlayDeck(deck);
            game.setDiscardDeck(new Deck());
        }

        return game;
    }

    @Override
    public void startRound(Game game) {
        game.setPlayerList(game.getRoom().getPlayerList());
        distributeInitialCards(game);
    }

    private void distributeInitialCards(Game game) {
        Deck playDeck = game.getPlayDeck();
        Dealer dealer = game.getRoom().getDealer();
        List<Player> playerList = game.getRoom().getPlayerList();
        game.setPlayerList(playerList);
        playersGeTCard(playerList, playDeck);
        dealer.getDealerHand().getCardHand().add(deckService.getCard(playDeck, false));
        playersGeTCard(playerList, playDeck);
        dealer.getDealerHand().getCardHand().add(deckService.getCard(playDeck, true));
    }

    private void playersGeTCard(List<Player> playerList, Deck deck) {

        for (Player player : playerList) {
            List<PlayerHand> handList = player.getPlayerHandList();
            if (handList == null) {
                handList = new ArrayList<>();
            }

            PlayerHand currHand;
            if (handList.size() == 0)
                currHand = new PlayerHand();
            else
                currHand = handList.get(0);

            currHand.getCardHand().add(deckService.getCard(deck, true));
            if (handList.size() == 0)
                handList.add(currHand);
            else
                handList.set(0, currHand);

            player.setPlayerHandList(handList);
        }
    }

}
