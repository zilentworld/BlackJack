package com.jiro.controller;

import com.jiro.dao.ChipDao;
import com.jiro.model.*;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @Autowired
    private static RoomService roomService;
    @Autowired
    private static GameService gameService;
    @Autowired
    private ChipDao chipDao;


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

    @RequestMapping("/chip")
    @ResponseBody
    public String searchChip(int chipAmount) {
        Chip chip = null;
        try {
             chip = chipDao.findByChipAmount(chipAmount);
        }
        catch (Exception ex) {
            return "Chip not found";
        }
        return "chip:"+chip.getChipDesc();
    }

}