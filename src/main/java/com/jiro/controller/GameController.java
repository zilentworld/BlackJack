package com.jiro.controller;

import com.jiro.model.Dealer;
import com.jiro.model.Game;
import com.jiro.model.Player;
import com.jiro.model.Room;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @Autowired
    private static RoomService roomService;
    @Autowired
    private static GameService gameService;

    @RequestMapping("/play")
    public String play(Model model) {

//        RoomService roomService = new RoomServiceImpl();
//        GameService gameService = new GameServiceImpl();

        Dealer dealer = new Dealer();
        Room room = roomService.createNewRoom(dealer);

        Player p1 = new Player(1);
        Player p2 = new Player(2);

        roomService.joinRoom(room, p1);
        roomService.joinRoom(room, p2);

        Game game = gameService.createNewGame(room);
        gameService.startRound(game);

        System.out.println("Dealer Hand:");
        System.out.println(dealer.getDealerHand().toString());
        System.out.println("Player hands:");
        game.getPlayerList().forEach(player -> player.getPlayerHandList().forEach(System.out::println));

        return "play";
    }

}