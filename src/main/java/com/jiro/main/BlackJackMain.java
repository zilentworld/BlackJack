package com.jiro.main;

import com.jiro.model.Dealer;
import com.jiro.model.Game;
import com.jiro.model.Room;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import com.jiro.service.impl.GameServiceImpl;
import com.jiro.service.impl.RoomServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackJackMain {

    public static void main(String[] args) {
        RoomService roomService = new RoomServiceImpl();
        GameService gameService = new GameServiceImpl();

        Dealer dealer = new Dealer();
        Room room = roomService.createNewRoom(dealer);

        Game game = gameService.createNewGame(room);

        System.out.println(game.getPlayDeck());
    }

}
