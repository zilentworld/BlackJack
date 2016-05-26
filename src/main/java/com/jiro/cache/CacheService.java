package com.jiro.cache;

import com.jiro.model.Player;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dev-pc on 5/26/16.
 */
public interface CacheService {

    ConcurrentHashMap<Long, Player> getPlayerMap();
}
