package com.jiro.service;

import com.jiro.model.Account;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
public interface AccountService {

    boolean canMakeBet(Account player, int betAmount);

    void deductChips(Account player, int chipAmount);

    void increaseChips(Account player, int chipAmount);

    Account createNewPlayer(String username, String password, Integer initialChips);

    Account createNewDealer(String username, String password);

    Account findById(long accountId) throws RemoteException;

    void saveAccount(Account account);

    List<Account> findAll();
}
