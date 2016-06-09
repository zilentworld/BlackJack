package com.jiro.jms;

import com.jiro.model.Account;
import com.jiro.service.AccountService;
import com.jiro.service.JmsHandlerService;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dev-pc on 6/8/16.
 */
@Component
public class AccountReceiver {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JmsHandlerService jmsHandlerService;

    @JmsListener(destination = "account-receiver")
    public void requestAccount(ObjectMessage objectMessage) {
        try {
            System.out.println(objectMessage.getJMSCorrelationID());
            Destination d = objectMessage.getJMSReplyTo();

            String replyTo = "";
            if (d instanceof Topic)
                replyTo = ((Topic) d).getTopicName();

            System.out.println("replyTo:"+replyTo);

            Long accountId = (Long) objectMessage.getObject();

            System.out.println("ACCOUNT RECEIVER:accountId:"+accountId);
            Account account = accountService.findById(accountId);

            System.out.println(account.toString());

            Map<String, String> zz = new HashMap<>();
            zz.put(objectMessage.getJMSCorrelationID(), account.toString());

            jmsHandlerService.convertSendJms(replyTo, zz);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "listaccount-receiver")
    public void requestAllAccounts(ObjectMessage objectMessage) {
        try {
            System.out.println("ACCOUNT List");

            List<String> z = new ArrayList<>();
            accountService.findAll().forEach(account1 -> z.add(account1.toString()));
            Map<String, List<String>> zz = new HashMap<>();
            zz.put(objectMessage.getJMSCorrelationID(), z);

            Destination d = objectMessage.getJMSReplyTo();
            String replyTo = "";
            if (d instanceof Topic)
                replyTo = ((Topic) d).getTopicName();

            System.out.println("replyTo:"+replyTo);

            jmsHandlerService.convertSendJms(replyTo, zz);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
