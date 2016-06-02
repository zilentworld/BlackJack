package com.jiro.service;

import com.jiro.model.Account;
import com.jiro.model.Room;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface RoomPlayerService {

    void addRoomPlayer(Room room, Account account);

}
