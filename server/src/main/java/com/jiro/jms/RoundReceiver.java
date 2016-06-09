package com.jiro.jms;

import com.jiro.model.Round;
import com.jiro.service.JmsHandlerService;
import com.jiro.service.RoundService;
import com.jiro.service.impl.RoundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 6/9/16.
 */
@Component
public class RoundReceiver {

    @Autowired
    private JmsHandlerService jmsHandlerService;

    @Autowired
    private RoundService roundService;


    @JmsListener(destination = "dealer-receiver")
    public void findDealerRounds(ObjectMessage objectMessage) {
        try {
            System.out.println("ACCOUNT List");
            Long dealerId = (Long) objectMessage.getObject();
            List<Round> dealerRoundList = roundService.getDealerRounds(dealerId);
            List<String> dealerDataList = new ArrayList<>();
            dealerRoundList.forEach(round -> {
                StringBuilder sb = new StringBuilder();
                sb.append("Dealer name:" + round.getDealer().getUsername() + "\n");
                sb.append("Room Number:" + round.getGame().getRoom().getRoomId() + "\n");
                sb.append("Game Id:" + round.getGame().getGameId() + "\n");
                dealerDataList.add(sb.toString());
            });
            Destination d = objectMessage.getJMSReplyTo();
            String replyTo = "";
            if (d instanceof Topic)
                replyTo = ((Topic) d).getTopicName();

            Map<String, List<String>> zz = new HashMap<>();
            zz.put(objectMessage.getJMSCorrelationID(), dealerDataList);

            System.out.println("replyTo:"+replyTo);
            System.out.println("objectMessage.getJMSCorrelationID():"+objectMessage.getJMSCorrelationID());

            jmsHandlerService.convertSendJms(replyTo, zz);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
