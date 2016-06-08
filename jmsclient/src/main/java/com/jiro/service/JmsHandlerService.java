package com.jiro.service;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by dev-pc on 6/8/16.
 */
@Component
public interface JmsHandlerService {

    void sendJms(String dest, Serializable s);

    void convertSendJms(String dest, Object o);

}
