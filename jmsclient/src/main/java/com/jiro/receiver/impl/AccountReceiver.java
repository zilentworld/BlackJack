package com.jiro.receiver.impl;

import com.jiro.receiver.Receiver;
import org.springframework.jms.annotation.JmsListener;

import java.util.Map;

/**
 * Created by dev-pc on 6/8/16.
 */
public class AccountReceiver extends Receiver {

    @JmsListener(destination = "account-destination")
    public void receiveMessage(Map<String, String> accountString) {
        System.out.println("jmsclient");
        System.out.println(accountString);
        getResultMap().putAll(accountString);
    }
}
