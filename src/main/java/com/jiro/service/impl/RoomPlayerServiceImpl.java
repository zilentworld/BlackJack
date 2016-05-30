package com.jiro.service.impl;

import com.jiro.model.Account;
import com.jiro.model.Room;
import com.jiro.model.RoomPlayer;
import com.jiro.service.RoomPlayerService;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/30/16.
 */
@Service
public class RoomPlayerServiceImpl implements RoomPlayerService {

    @Override
    public void addRoomPlayer(Room room, Account account) {
        room.getRoomPlayersList().add(new RoomPlayer(account));
    }

}
