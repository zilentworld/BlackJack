package com.jiro.service;

import com.jiro.model.Player;

import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
public interface PlayerService {

    List<Player> getPlayerList();

    boolean makeBet(Player player, int betAmount);

}
