package com.jiro.service;

import com.jiro.model.Dealer;
import com.jiro.model.Player;
import com.jiro.model.Room;

public interface RoomService {

    Room createNewRoom (Dealer dealer);

    void joinRoom (Room room, Player player);
}
