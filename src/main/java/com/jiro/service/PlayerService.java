package com.jiro.service;

import com.jiro.model.Account;

import java.util.List;

/**
 * Created by dev-pc on 5/27/16.
 */
public interface PlayerService {

    List<Account> getPlayerList();

    boolean makeBet(Account player, int betAmount);

}
