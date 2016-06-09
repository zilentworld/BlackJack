package com.jiro.controller;

import com.jiro.receiver.impl.AccountReceiver;
import com.jiro.receiver.impl.DealerReceiver;
import com.jiro.service.JmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev-pc on 5/26/16.
 */
@Controller
@RestController
public class BaseController {

    @Autowired
    private JmsHandlerService jmsHandlerService;
    @Autowired
    private AccountReceiver accountReceiver;
    @Autowired
    private DealerReceiver dealerReceiver;



    @RequestMapping("/listAllAccounts")
    @ResponseBody
    public String listAccounts(ModelMap model) {
        System.out.println("List Accounts");

        // Send a message
        StringBuilder sb = new StringBuilder();

        accountReceiver.getListResult(jmsHandlerService.sendJms("listaccount-receiver", "account-destination", 0L)).forEach(s -> sb.append(s + "\n"));

        System.out.println(sb.toString());
        return sb.toString();
    }

    @RequestMapping("/searchAccount")
    @ResponseBody
    public String searchAccount(@RequestParam(required = true) long accountId, ModelMap model) {
        System.out.println("Search Account");
        String out = accountReceiver.getStringResult(jmsHandlerService.sendJms("account-receiver", "account-destination", accountId));

        System.out.println(out);
        return out;
    }

    @RequestMapping("/getDealerRooms")
    @ResponseBody
    public String getUserBetRecord(@RequestParam(required = true) long dealerId, ModelMap model) {
        System.out.println("Search Account");
        StringBuilder sb = new StringBuilder();
        dealerReceiver.getListResult(jmsHandlerService.sendJms("dealer-receiver", "dealer-destination", dealerId)).forEach(s -> sb.append(s + "\n"));
        System.out.println(sb.toString());
        return sb.toString();
    }

    @RequestMapping("findRound")
    @ResponseBody
    public String findRound(@RequestParam(required = true) long roundId, ModelMap model) {
        System.out.println("Search Account");
        String out = dealerReceiver.getStringResult(jmsHandlerService.sendJms("round-receiver", "round-destination", roundId));
        System.out.println(out);
        return out;
    }

}
