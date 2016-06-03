package com.jiro.service;

import com.jiro.model.Account;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface AccountService {

    boolean canMakeBet(Account player, int betAmount);

    void deductChips(Account player, int betAmount);

    Account createNewPlayer(String username, String password, Integer initialChips);

    Account createNewDealer(String username, String password);

    Account findById(long accountId) throws RemoteException;
}