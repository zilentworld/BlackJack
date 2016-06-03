package com.jiro;

import com.jiro.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dev-pc on 6/2/16.
 */
@SpringBootApplication
@Controller
public class ClientMain {

    @RequestMapping("/tesz")
    @ResponseBody
    public String tesz() {
        return "AASDASDASD";
    }

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = (AccountService) ctx.getBean("accountService");
//        System.out.println(accountService.findById(22).getId());
        SpringApplication.run("classpath:/applicationContext.xml", args);
    }
}