package com.jiro.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.jiro.model", "com.jiro.service", "com.jiro.dao", "com.jiro.controller"})
public class BlackJackMain {

    public static void main(String[] args) {
        SpringApplication.run(BlackJackMain.class, args);
    }

}
