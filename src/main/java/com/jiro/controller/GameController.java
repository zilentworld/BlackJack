package com.jiro.controller;

import com.jiro.dao.PlayerDao;
import com.jiro.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    @Autowired
    private PlayerDao playerDao;

    /*
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
        }*/

    @RequestMapping("/create")
    @ResponseBody
    public String create(String username, String password) {
        Player player = null;
        try {
            player = new Player(username, password);
            playerDao.save(player);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + player.getPlayerId() + ")";
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test(String username, String password) {
        System.out.println(playerDao.findByUsername(username).toString());
        System.out.println(playerDao.findByPassword(password).toString());
    }

}