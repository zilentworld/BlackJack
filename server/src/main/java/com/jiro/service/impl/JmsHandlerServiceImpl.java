package com.jiro.service.impl;

import com.jiro.service.JmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.io.Serializable;

/**
 * Created by dev-pc on 6/8/16.
 */
@Service
public class JmsHandlerServiceImpl implements JmsHandlerService {

    @Autowired
    private ConfigurableApplicationContext context;

    public void sendJms(String dest, Serializable s) {
        MessageCreator accountQuery = session -> session.createObjectMessage(s);
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.send(dest, accountQuery);
    }

    @Override
    public void convertSendJms(String dest, Object o) {
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend(dest, o);
    }
}
