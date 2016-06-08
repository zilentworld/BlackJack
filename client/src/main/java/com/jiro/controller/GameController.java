package com.jiro.controller;

import com.jiro.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class GameController {

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String createPlayer(@RequestParam(required = true) long userId,
                               ModelMap model) {

        accountService.findById(userId);

        return "test";
    }

}