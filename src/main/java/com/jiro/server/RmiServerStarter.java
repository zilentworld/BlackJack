package com.jiro.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dev-pc on 5/26/16.
 */
public class RmiServerStarter {

    public static void main(String[] args) {
        //RMI Server Application Context is started...
        new ClassPathXmlApplicationContext("rmiServerAppContext.xml");
    }
    
}
