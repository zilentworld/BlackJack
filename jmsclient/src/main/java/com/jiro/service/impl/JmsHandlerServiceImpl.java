package com.jiro.service.impl;

import com.jiro.service.JmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by dev-pc on 6/8/16.
 */
@Service
public class JmsHandlerServiceImpl implements JmsHandlerService {

    @Autowired
    private ConfigurableApplicationContext context;

    public String sendJms(String dest, String replyTo, Serializable s) {
        String corrId = createRandomString();
        MessageCreator accountQuery = session -> {
            Message z = session.createObjectMessage(s);
            z.setJMSCorrelationID(corrId);
            z.setJMSReplyTo(session.createTopic(replyTo));
            return z;
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.send(dest, accountQuery);

        return corrId;
    }

    @Override
    public String convertSendJms(String dest, String replyTo, Object o) {
        String corrId = createRandomString();
        /*MessageCreator accountQuery = session -> {
            Message z = session.createMessage();
            z.setJMSCorrelationID(corrId);
            return z;
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend(dest, o);*/

        return corrId;
    }

    private String createRandomString() {
        Random random = new Random(System.currentTimeMillis());
        long randomLong = random.nextLong();
        String zzz = Long.toHexString(randomLong);
        System.out.println("rndm:"+zzz);
        return zzz;
    }

}
