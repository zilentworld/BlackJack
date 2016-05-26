package com.jiro.rmi.impl;

import com.jiro.cache.CacheService;
import com.jiro.model.Player;
import com.jiro.rmi.RmiPlayerService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-pc on 5/26/16.
 */
public class RmiPlayerServiceImpl implements RmiPlayerService {

    private static Logger logger = Logger.getLogger(RmiPlayerService.class);
    CacheService cacheService;

    @Override
    public boolean addPlayer(Player player) {
        System.out.println("addPlayer:"+player.getUsername());
        getCacheService().getPlayerMap()
                .put(player.getPlayerId(), player);
        logger.debug("User has been added to cache. User : "+getCacheService().getPlayerMap().get(player.getPlayerId()));
        return true;
    }

    @Override
    public List<Player> getList() {
        List<Player> list = new ArrayList<Player>();
        list.addAll(getCacheService().getPlayerMap().values());
        logger.debug("User List : "+list);
        return list;
    }

    public CacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }
}
