package com.jiro;

import com.jiro.model.Dealer;
import com.jiro.model.Game;
import com.jiro.model.Player;
import com.jiro.model.Room;
import com.jiro.service.GameService;
import com.jiro.service.RoomService;
import com.jiro.service.impl.GameServiceImpl;
import com.jiro.service.impl.RoomServiceImpl;

import java.util.Scanner;

/**
 * Created by dev-pc on 5/27/16.
 */
public class BlackJackConsole {


    public static void main(String[] args) {

        RoomService roomService = new RoomServiceImpl();
        GameService gameService = new GameServiceImpl();

        Dealer dealer = new Dealer();
        Room room = roomService.createNewRoom(dealer);
        room.setRoomId(1);

        Game game = gameService.createNewGame(room);
        game.setGameId(1);

        Player p1 = new Player(1);
//        Player p2 = new Player(2);

        roomService.joinRoom(room, p1);
//        roomService.joinRoom(room, p2);

        try (Scanner sc = new Scanner(System.in)) {
            String nextLine = "";
            while (!"-1".equals(nextLine)) {

                gameService.startRound(game);
//
//                System.out.println("Dealer Hand:");
//                System.out.println(dealer.getDealerHand().toString());
//                System.out.println("Player hands:");
//                game.getPlayerList().forEach(player -> player.getPlayerHandList().forEach(System.out::println));



                System.out.println("Choose Action: (-1 for exit)");
                nextLine = sc.nextLine();
            }
        }
    }
}
