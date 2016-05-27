package com.jiro.service.impl;

import com.jiro.model.Player;
import com.jiro.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public List<Player> getPlayerList() {
        System.out.println("pumasok dito.");
        return null;
    }

    @Override
    public boolean makeBet(Player player, int betAmount) {
        if(player.getTotalChipAmount() < betAmount)
            return false;
        return true;
    }
}
