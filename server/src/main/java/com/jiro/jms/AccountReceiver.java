package com.jiro.jms;

import com.jiro.model.Account;
import com.jiro.service.AccountService;
import com.jiro.service.JmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

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
            Long accountId = (Long) objectMessage.getObject();
            System.out.println("ACCOUNT RECEIVER:accountId:"+accountId);
            Account account = accountService.findById(accountId);
            System.out.println(account.toString());

//            jmsTemplate.convertAndSend("account-destination",account.toString());
            List<String> z = new ArrayList<>();
            accountService.findAll().forEach(account1 -> z.add(account1.toString()));

            jmsHandlerService.convertSendJms("account-destination", z);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
