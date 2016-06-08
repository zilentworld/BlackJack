package com.jiro.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by dev-pc on 6/7/16.
 */
@Component
public class Receiver {


    /**
     * Get a copy of the application context
     */
//    @Autowired
//    ConfigurableApplicationContext context;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "mailbox-destination")
    public void receiveMessage(String message) {
        System.out.println("Received in server <" + message + ">");
//        context.close();
//        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
