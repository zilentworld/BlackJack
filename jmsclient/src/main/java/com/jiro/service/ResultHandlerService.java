package com.jiro.service;

import java.util.List;

/**
 * Created by dev-pc on 6/8/16.
 */
public interface ResultHandlerService {

    String getStringResult(String serverDest, String returnDestination, Object valueToSend);

    List<String> getListStringResult(String serverDest, String returnDestination, Object valueToSend);

}
