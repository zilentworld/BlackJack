package com.jiro.service.impl;

import com.jiro.model.Dealer;
import com.jiro.model.Room;
import com.jiro.service.RoomService;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl implements RoomService {

    public Room createNewRoom (Dealer dealer) {
        Room room = new Room();
        room.setDealer(dealer);

        return room;
    }
}
