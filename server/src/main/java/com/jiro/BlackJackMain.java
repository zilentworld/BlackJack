package com.jiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
@ImportResource(value = { "classpath:applicationContext.xml"})
@ComponentScan({"com.jiro"})
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
public class BlackJackMain
//        extends SpringBootServletInitializer
{

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(BlackJackMain.class);
//    }

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringApplication.run(BlackJackMain.class, args);
    }

}
