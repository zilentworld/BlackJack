package com.jiro.rmi;

import com.jiro.model.Player;

import java.util.List;

/**
 * Created by dev-pc on 5/26/16.
 */
public interface RmiPlayerService {

    boolean addPlayer(Player player);

    List<Player> getList();

}
