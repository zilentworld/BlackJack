package com.jiro.service.impl;

import com.jiro.service.ResultHandlerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-pc on 6/8/16.
 */
@Service
public class ResultHandlerServiceImpl implements ResultHandlerService {

    @Override
    public String getStringResult(String serverDest, String returnDestination, Object valueToSend) {
        return null;
    }

    @Override
    public List<String> getListStringResult(String serverDest, String returnDestination, Object valueToSend) {
        return null;
    }
}
