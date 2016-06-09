package com.jiro.receiver.impl;

import com.jiro.receiver.Receiver;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 6/9/16.
 */
@Component
public class DealerReceiver extends Receiver {

    public String getStringResult(String corrId) {
        return (String) getObject(corrId);
    }

    public List<String> getListResult(String corrId) {
        return (List<String>) getObject(corrId);
    }

    @JmsListener(destination = "dealer-destination")
    public void receiveMessage(Map<String, List<String>> dealerString) {
        System.out.println("jmsclient:dealer-destination");
        System.out.println(dealerString);
        getResultMap().putAll(dealerString);
    }
}
