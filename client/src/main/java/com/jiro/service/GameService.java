package com.jiro.service;

import com.jiro.model.Game;
import com.jiro.model.Room;

public interface GameService {

    Game createNewGame(long roomId);

    Game createNewGame(Room room);

    Game findById(long gameId);

}
