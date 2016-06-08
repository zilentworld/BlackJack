package com.jiro.controller;

import com.jiro.service.JmsHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dev-pc on 5/26/16.
 */
@Controller
@RestController
public class BaseController {

    @Autowired
    private JmsHandlerService jmsHandlerService;

    @RequestMapping("/testz")
    @ResponseBody
    public String testz(Map<String, Object> model) {
        System.out.println("jms testz");

        // Send a message
        jmsHandlerService.sendJms("account-receiver", 39L);

        return "index";
    }

}
