package com.jiro.service;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by dev-pc on 6/8/16.
 */
@Component
public interface JmsHandlerService {

    String sendJms(String dest, String replyTo, Serializable s);

    String convertSendJms(String dest, String replyTo, Object o);

}
