package com.jiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by dev-pc on 6/2/16.
 */
@SpringBootApplication
//@ComponentScan("com.jiro")
//@ImportResource(locations = {"classpath:/applicationContext.xml"})
public class ClientMain {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = (AccountService) ctx.getBean("accountService");
//        System.out.println(accountService.findById(22).getId());
//        SpringApplication.run("classpath:/remoting-servlet.xml", args);
        SpringApplication.run("classpath:/applicationContext.xml", args);
//        SpringApplication.run(ClientMain.class, args);
    }
}