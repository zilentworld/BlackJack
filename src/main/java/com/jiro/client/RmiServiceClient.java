package com.jiro.client;

import com.jiro.model.Player;
import com.jiro.rmi.RmiPlayerService;
import com.jiro.rmi.impl.RmiPlayerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dev-pc on 5/26/16.
 */
public class RmiServiceClient {

    private static Logger logger = Logger.getLogger(RmiPlayerService.class);

    public static void main(String[] args) {
        logger.debug("RMI Service Client is starting...");
        ApplicationContext context = new ClassPathXmlApplicationContext("rmiClientAppContext.xml");
        //Remote User Service is called via RMI Client Application Context...
        RmiPlayerService rmiClient = (RmiPlayerService) context.getBean("RMIUserService");
        //New User is created...
        Player player = new Player();
        player.setPlayerId(2);
        player.setUsername("user:"+player.getPlayerId());
        player.setPassword("pass:"+player.getPassword());
        rmiClient.addPlayer(player);
        rmiClient.getList();
        logger.debug("RMI Service Client is stopped...");
    }


}
