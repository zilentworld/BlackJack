package com.jiro.receiver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev-pc on 6/7/16.
 */
public abstract class Receiver {

    private static Map<String, Object> resultMap = new HashMap<>();

    protected static Map<String, Object> getResultMap() {
        return resultMap;
    }

    protected static void setResultMap(Map<String, Object> resultMap) {
        Receiver.resultMap = resultMap;
    }

    protected static Object getObject(String corrId) {
        Object o = null;
        for(int a = 0; a < 5; a++) {
            System.out.println("getObject:a:"+a);
            o = getResultMap().get(corrId);
            if (o == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else
                break;
        }
        return o;
    }
}
