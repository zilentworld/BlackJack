package com.jiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
//@ComponentScan({"com.jiro.model", "com.jiro.service", "com.jiro.dao", "com.jiro.controller"})
public class BlackJackMain
//        extends SpringBootServletInitializer
{

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(BlackJackMain.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(BlackJackMain.class, args);
    }

}
