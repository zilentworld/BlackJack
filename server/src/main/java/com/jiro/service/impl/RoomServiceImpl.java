package com.jiro.service.impl;

import com.jiro.dao.AccountDao;
import com.jiro.dao.RoomDao;
import com.jiro.model.Account;
import com.jiro.model.Game;
import com.jiro.model.Room;
import com.jiro.service.AccountService;
import com.jiro.service.RoomPlayerService;
import com.jiro.service.RoomService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Calendar;


@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomPlayerService roomPlayerService;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private AccountService accountService;

    @Override
    public Room createNewRoom(long dealerId) {
        try {
            return createNewRoom(accountService.findById(dealerId));
        } catch (RemoteException e) {
            System.out.println("remote exe1");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room createNewRoom (Account dealer) {
        if(!dealer.isDealer()) {
            System.out.println("Not a dealer");
            return null;
        }
        Room room = new Room();
        room.setDealer(dealer);
        roomDao.save(room);

        return room;
    }

    @Override
    public void joinRoom(long roomId, long playerId) {
        try {
            joinRoom(findById(roomId), accountService.findById(playerId));
        } catch (RemoteException e) {
            System.out.println("remove exe2");
            e.printStackTrace();
        }
    }

    @Override
    public void joinRoom(Room room, Account player) {
        if(player != null) {
            roomPlayerService.addRoomPlayer(room, player);
            System.out.println(player.getUsername() + " has join room " + room.getRoomId());
        }
    }

    @Override
    public Room findById(long roomId) {
        return roomDao.findOne(roomId);
    }

    @Override
    public void saveRoom(Room room) {
        roomDao.save(room);
    }

    @Override
    public void addGame(Room room, Game game) {
        Hibernate.initialize(room.getGameList());
        room.getGameList().add(game);
    }

    @Override
    public void leaveRoom(Room room, Account player) {
        room.getRoomPlayersList().remove(player);
    }

    @Override
    public void dealerLeaveRoom(Room room, Account dealer) {
        if(room.getDealer().getId() == dealer.getId()) {
            room.setDestroyTime(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
            roomDao.save(room);
        }
    }
}
