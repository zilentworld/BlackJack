package com.jiro.controller;

import com.jiro.dao.RoundPlayerCardHandDao;
import com.jiro.model.*;
import com.jiro.service.*;
import com.jiro.service.impl.RoundPlayerCardHandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class GameController {
//
//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private RoomService roomService;
//    @Autowired
//    private GameService gameService;
//    @Autowired
//    private RoundService roundService;
//    @Autowired
//    private RoundPlayerCardHandService roundPlayerCardHandService;
//
//
//    @RequestMapping("/createPlayer")
//    @ResponseBody
//    public String createPlayer(@RequestParam(required = true) String username,
//                               @RequestParam(required = true) String password,
//                               @RequestParam(required = false) Integer initialChips,
//                               ModelMap model) {
//        String output;
//        try {
//            Account player = accountService.createNewPlayer(username, password, initialChips);
//            output = "User successfully created! (id = " + player.getId() + ")";
//        } catch (Exception ex) {
//            output = "Error creating the user: " + ex.toString();
//        }
//        System.out.println(output);
//        model.addAttribute("result1", output);
//
//        return "test";
//    }
//
//    @RequestMapping("/createDealer")
//    @ResponseBody
//    public String createDealer(@RequestParam(required = true) String username,
//                               @RequestParam(required = true) String password,
//                               ModelMap model) {
//        String output;
//        try {
//            Account dealer = accountService.createNewDealer(username, password);
//            output = "User successfully created! (id = " + dealer.getId() + ")";
//        } catch (Exception ex) {
//            output = "Error creating the user: " + ex.toString();
//        }
//        System.out.println(output);
//        model.addAttribute("result1", output);
//
//        return "test";
//    }
//
//    @RequestMapping("/createRoom")
//    @ResponseBody
////    @ResponseBody // means the string output is the result itself,
//    // without it the function name.html will be called
//    public String createRoom(@RequestParam(required = true) long dealerId,
//                             ModelMap model) {
//
//        String output = "";
//        Room room = roomService.createNewRoom(dealerId);
//        if (room == null) {
//            System.out.println("failed in creating room");
//            output = "failed in creating room";
//            model.addAttribute("result1", output);
//            return "test";
//        }
//
//        System.out.println("room id:" + room.getRoomId());
//        output = "room id:" + room.getRoomId();
//        model.addAttribute("result1", output);
//        return "test";
//    }
//
//    @RequestMapping("/joinRoom")
//    @ResponseBody
//    public String joinRoom(@RequestParam(required = true) long roomId,
//                           @RequestParam(required = true) long playerId,
//                           ModelMap model) {
//        roomService.joinRoom(roomId, playerId);
//        System.out.println("joined room:" + roomId);
//        String output = "joined room:" + roomId;
//        model.addAttribute("result1", output);
//
//        return "test";
//    }
//
//    @RequestMapping("/newGame")
//    @ResponseBody
//    public String newGame(@RequestParam(required = true) long roomId, ModelMap model) {
//        Game game = gameService.createNewGame(roomId);
//        model.addAttribute("result1", "game id:" + game.getGameId());
//        System.out.println("game id:" + game.getGameId());
//
//        return "test";
//    }
//
//    @ResponseBody
//    @RequestMapping("/newRound")
//    public String newRound(@RequestParam(required = true) long gameId, ModelMap model) {
//        Round round = roundService.createNewRound(gameId);
//        model.addAttribute("result1", "round id:" + round.getRoundId());
//        System.out.println("round id:" + round.getRoundId());
//
//        return "test";
//    }
//
//    @RequestMapping("/joinRound")
//    @ResponseBody
//    public String joinRound(@RequestParam(required = true) long roundId,
//                            @RequestParam(required = true) long playerId,
//                            @RequestParam(required = true) int betAmount,
//                            ModelMap model) {
//        roundService.joinRound(roundId, playerId, betAmount);
//        model.addAttribute("result1", "Player id:" + playerId + " has joined round :" + roundId + " with bet amount :" + betAmount);
//        System.out.println("Player id:" + playerId + " has joined round :" + roundId + " with bet amount :" + betAmount);
//
//        return "test";
//    }
//
//    @RequestMapping("/startRound")
//    @ResponseBody
//    public String startRound(@RequestParam(required = true) long roundId,
//                             ModelMap model) {
//        roundService.startRound(roundId);
//        model.addAttribute("result1", roundService.findById(roundId).toString());
//        model.addAttribute("result2", roundService.findById(roundId).getGame().getPlayDeck().toString());
////        System.out.println("result1:"+roundService.findById(roundId).toString());
////        System.out.println("result2:"+ roundService.findById(roundId).getGame().getPlayDeck().toString());
//
//        return "test";
//    }
//
//    @RequestMapping("/doubleHand")
//    @ResponseBody
//    public String doubleHand(@RequestParam(required = true) long roundCardHandId,
//                             ModelMap model) {
//        roundPlayerCardHandService.playDouble(roundCardHandId);
//
//        Round round = roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound();
//
//        model.addAttribute("result1", round.toString());
//        model.addAttribute("result2", round.getGame().getPlayDeck().toString());
//
//        System.out.println("result1"+ roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound().toString());
//
//        return "test";
//    }
//
//    @RequestMapping("/hitHand")
//    @ResponseBody
//    public String hitHand(@RequestParam(required = true) long roundCardHandId,
//                             ModelMap model) {
//        roundPlayerCardHandService.playHit(roundCardHandId);
//
//        Round round = roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound();
//
//        model.addAttribute("result1", round.toString());
//        model.addAttribute("result2", round.getGame().getPlayDeck().toString());
//
//        System.out.println("result1"+ roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound().toString());
//
//        return "test";
//    }
//
//    @RequestMapping("/standHand")
//    @ResponseBody
//    public String standHand(@RequestParam(required = true) long roundCardHandId,
//                             ModelMap model) {
//        roundPlayerCardHandService.playStand(roundCardHandId);
//
//        Round round = roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound();
//
//        model.addAttribute("result1", round.toString());
//        model.addAttribute("result2", round.getGame().getPlayDeck().toString());
//
//        System.out.println("result1"+ roundPlayerCardHandService.findById(roundCardHandId).getRoundPlayer().getRound().toString());
//
//        return "test";
//    }
//
//    @RequestMapping("/dealerTurn")
//    @ResponseBody
//    public String dealerTurn(@RequestParam(required = true) long roundId, ModelMap model) {
//        System.out.println("dealer turn");
//        roundService.finishDealerHand(roundId);
//        Round round = roundService.findById(roundId);
//        model.addAttribute("result1", round.toString());
//        System.out.println(round.toString());
//
//        roundService.finishRound(roundId);
//        System.out.println(round.toString());
//
//        return "test";
//    }

}