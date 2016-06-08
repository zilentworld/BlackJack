package com.jiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;

@SpringBootApplication
@EnableJms
public class Application {



//    @Bean
//        // Strictly speaking this bean is not necessary as boot creates a default
//    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        return factory;
//    }

	public static void main(String[] args) {
		// Clean out any ActiveMQ data from a previous run
		FileSystemUtils.deleteRecursively(new File("activemq-data"));

		// Launch the application
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Send a message
//		MessageCreator messageCreator = session -> session.createTextMessage("ping!");

        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		for(int a = 0; a < 5; a++) {
			System.out.println("Sending a new message.");
			jmsTemplate.send("mailbox-destination", messageCreator);
			System.out.println("SENT");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		context.close();
	}
}
