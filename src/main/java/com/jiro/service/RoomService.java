package com.jiro.service;

import com.jiro.constants.Constants;
import com.jiro.model.Dealer;
import com.jiro.model.Deck;
import com.jiro.model.Room;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/24/16.
 */
@Service
public class RoomService {

    public Room initializeRoom () {

        Room room = new Room();
        Deck deck = new Deck();
        room.setDeck(deck);

        DeckService deckService = new DeckService();
        deck.setDeckSize(Constants.DEFAULT_DECK_SIZE);
        deckService.populateDeck(deck);

        Dealer dealer = new Dealer();
        room.setDealer(dealer);

        return room;
    }
}
