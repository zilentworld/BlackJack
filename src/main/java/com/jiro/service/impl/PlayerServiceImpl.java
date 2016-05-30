package com.jiro.service.impl;

import com.jiro.model.Account;
import com.jiro.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public List<Account> getPlayerList() {
        System.out.println("pumasok dito.");
        return null;
    }

    @Override
    public boolean makeBet(Account player, int betAmount) {
        if(player.getTotalChips() < betAmount)
            return false;
        return true;
    }
}
