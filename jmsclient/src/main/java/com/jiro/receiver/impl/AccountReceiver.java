package com.jiro.receiver.impl;

import com.jiro.receiver.Receiver;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 6/8/16.
 */
@Component
public class AccountReceiver extends Receiver {

    public String getStringResult(String corrId) {
        return (String) getObject(corrId);
    }

    public List<String> getListResult(String corrId) {
        return (List<String>) getObject(corrId);
    }

    @JmsListener(destination = "account-destination")
    public void receiveMessage(Map<String, List<String>> accountString) {
        System.out.println("jmsclient:account-destination");
        System.out.println(accountString);
        getResultMap().putAll(accountString);
    }
}
