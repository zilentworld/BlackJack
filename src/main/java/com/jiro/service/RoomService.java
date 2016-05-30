package com.jiro.service;

import com.jiro.model.Account;
import com.jiro.model.Game;
import com.jiro.model.Room;

public interface RoomService {

    Room createNewRoom (long dealerId);

    Room createNewRoom (Account dealer);

    void joinRoom (Room room, Account player);

    void joinRoom (long roomId, long playerId);

    Room findById(long roomId);

    void saveRoom(Room room);

    void addGame(Room room, Game game);

    void leaveRoom(Room room, Account player);

    void dealerLeaveRoom(Room room, Account dealer);
}
