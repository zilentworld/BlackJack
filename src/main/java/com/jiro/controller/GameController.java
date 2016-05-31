package com.jiro.controller;

import com.jiro.model.Account;
import com.jiro.model.Room;
import com.jiro.service.AccountService;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import com.jiro.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String createPlayer(@RequestParam(required = true) String username,
                             @RequestParam(required = true) String password,
                             @RequestParam(required = false) Integer initialChips,
                             ModelMap model) {
        String output = "";
        try {
            Account player = accountService.createNewPlayer(username, password, initialChips);
            output = "User successfully created! (id = " + player.getId() + ")";
        } catch (Exception ex) {
            output = "Error creating the user: " + ex.toString();
        }
        System.out.println(output);
        model.addAttribute("result1", output);

        return "test";
    }

    @RequestMapping("/createDealer")
    public String createDealer(@RequestParam(required = true) String username,
                             @RequestParam(required = true) String password,
                               ModelMap model) {
        String output = "";
        try {
            Account dealer = accountService.createNewDealer(username, password);
            output = "User successfully created! (id = " + dealer.getId() + ")";
        } catch (Exception ex) {
            output = "Error creating the user: " + ex.toString();
        }
        System.out.println(output);
        model.addAttribute("result1", output);

        return "test";
    }

    @RequestMapping("/createRoom")
//    @ResponseBody // means the string output is the result itself,
    // without it the function name.html will be called
    public String createRoom(@RequestParam(required = true) long dealerId,
                           ModelMap model) {

        String output = "";
        Room room = roomService.createNewRoom(dealerId);
        if (room == null) {
            System.out.println("failed in creating room");
            output = "failed in creating room";
            return "test";
        }

        System.out.println("room id:" + room.getRoomId());
        output = "room id:" + room.getRoomId();
        model.addAttribute("result1", output);
        return "test";
    }

    @RequestMapping("/joinRoom")
    @ResponseBody
    public String joinRoom(@RequestParam(required = true) long roomId,
                           @RequestParam(required = true) long playerId,
                           ModelMap model) {
        roomService.joinRoom(roomId, playerId);
        System.out.println("joined room:"+roomId);
        String output = "joined room:"+roomId;

        return "test";
    }

    @RequestMapping("/newGame")
    public String newGame(@RequestParam(required = true) long roomId, ModelMap model) {
        gameService.createNewGame(roomId);

        return "test";
    }

    @RequestMapping("/newRound")
    public String newRound(long gameId, ModelMap model) {
        roundService.createNewRound(gameId);

        return "test";
    }

    @RequestMapping("/joinRound")
    public String joinRound(long roundId, long playerId, int betAmount, ModelMap model) {
        roundService.joinRound(roundId, playerId, betAmount);
//        model.addAttribute("result1", roundService.findById(roundId).toString());

        return "test";
    }

    @RequestMapping("/startRound")
    public String startRound(long roundId, ModelMap model) {
        roundService.startRound(roundId);
        model.addAttribute("result1", roundService.findById(roundId).toString());

        return "test";
    }
}