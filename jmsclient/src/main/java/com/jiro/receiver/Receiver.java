package com.jiro.receiver;

import java.util.Map;

/**
 * Created by dev-pc on 6/7/16.
 */
public abstract class Receiver {

    private static Map<String, Object> resultMap;

    public static Map<String, Object> getResultMap() {
        return resultMap;
    }

    public static void setResultMap(Map<String, Object> resultMap) {
        Receiver.resultMap = resultMap;
    }
}
