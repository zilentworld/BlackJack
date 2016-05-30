package com.jiro.service.impl;

import com.jiro.constants.Constants;
import com.jiro.dao.GameDao;
import com.jiro.model.Deck;
import com.jiro.model.Game;
import com.jiro.model.Room;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private RoomService roomService;

    @Override
    public Game createNewGame(long roomId) {
        return createNewGame(roomService.findById(roomId));
    }

    @Override
    public Game createNewGame(Room room) {
        Deck deck = new Deck(Constants.DEFAULT_DECK_SIZE);

        deck.populateDeck();
        deck.shuffleDeck();

        System.out.println(room.getDealer().getId());

        Game game = new Game(room, deck);
        System.out.println("1");
        gameDao.save(game);

        System.out.println("2");
        roomService.addGame(room, game);
        System.out.println("3");
        roomService.saveRoom(room);
        System.out.println("4");

        return game;
    }

    @Override
    public Game findById(long gameId) {
        return gameDao.findOne(gameId);
    }

}
