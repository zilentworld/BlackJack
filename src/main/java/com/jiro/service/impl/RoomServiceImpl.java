package com.jiro.service.impl;

import com.jiro.model.Dealer;
import com.jiro.model.Player;
import com.jiro.model.Room;
import com.jiro.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RoomServiceImpl implements RoomService {

    public Room createNewRoom (Dealer dealer) {
        Room room = new Room();
        room.setDealer(dealer);

        return room;
    }

    @Override
    public void joinRoom(Room room, Player player) {
        if(player != null) {
            if (room.getPlayerList() == null)
                room.setPlayerList(new ArrayList<>());

            room.getPlayerList().add(player);
        }
    }
}
