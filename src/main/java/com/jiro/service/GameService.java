package com.jiro.service;

import com.jiro.model.Game;
import com.jiro.model.Room;

public interface GameService {

    Game createNewGame(Room room);

    void newRound(Game game);

}
