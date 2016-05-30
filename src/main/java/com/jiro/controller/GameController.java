package com.jiro.controller;

import com.jiro.model.Account;
import com.jiro.model.Room;
import com.jiro.service.AccountService;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import com.jiro.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private GameService gameService;
    @Autowired
    private RoundService roundService;


    @RequestMapping("/createPlayer")
    public void createPlayer(@RequestParam(required = true) String username,
                             @RequestParam(required = true) String password,
                             @RequestParam(required = false) Integer initialChips) {
        String output = "";
        try {
            Account player = accountService.createNewPlayer(username, password, initialChips);
            output = "User successfully created! (id = " + player.getId() + ")";
        } catch (Exception ex) {
            output = "Error creating the user: " + ex.toString();
        }
        System.out.println(output);
    }

    @RequestMapping("/createDealer")
    public void createDealer(@RequestParam(required = true) String username,
                             @RequestParam(required = true) String password) {
        String output = "";
        try {
            Account dealer = accountService.createNewDealer(username, password);
            output = "User successfully created! (id = " + dealer.getId() + ")";
        } catch (Exception ex) {
            output = "Error creating the user: " + ex.toString();
        }
        System.out.println(output);
    }

    @RequestMapping("/createRoom")
    @ResponseBody // means the string output is the result itself,
    // without it the function name.html will be called
    public void createRoom(@RequestParam(required = true) long dealerId) {

        Room room = roomService.createNewRoom(dealerId);
        if (room == null) {
            System.out.println("failed in creating room");
            return;
        }

        System.out.println("room id:" + room.getRoomId());
    }

    @RequestMapping("/joinRoom")
    @ResponseBody
    public String joinRoom(@RequestParam(required = true) long roomId,
                           @RequestParam(required = true) long playerId) {
        roomService.joinRoom(roomId, playerId);
        System.out.println("joined room");

        return "createRoom";
    }

    @RequestMapping("/newGame")
    public String newGame(@RequestParam(required = true) long roomId) {
        gameService.createNewGame(roomId);

        return "createRoom";
    }

    @RequestMapping("/newRound")
    public String newRound(long gameId) {
        roundService.createNewRound(gameId);

        return "createRoom";
    }

    @RequestMapping("/joinRound")
    public String joinRound(long roundId, long playerId, int betAmount) {
        roundService.joinRound(roundId, playerId, betAmount);

        return "createRoom";
    }

    @RequestMapping("/startRound")
    public String startRound(long roundId) {
        roundService.startRound(roundId);

        return "createRoom";
    }
}