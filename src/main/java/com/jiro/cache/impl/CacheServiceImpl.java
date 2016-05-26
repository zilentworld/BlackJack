package com.jiro.cache.impl;

import com.jiro.cache.CacheService;
import com.jiro.model.Player;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dev-pc on 5/26/16.
 */
public class CacheServiceImpl implements CacheService {

    ConcurrentHashMap<Long, Player> playerMap;

    @Override
    public ConcurrentHashMap<Long, Player> getPlayerMap() {
        return null;
    }

    public void setPlayerMap(ConcurrentHashMap<Long, Player> playerMap) {
        this.playerMap = playerMap;
    }
}
