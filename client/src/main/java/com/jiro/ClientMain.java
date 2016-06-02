package com.jiro;

import com.jiro.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dev-pc on 6/2/16.
 */
public class ClientMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        System.out.println(accountService.findById(22).getId());
    }
}