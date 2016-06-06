package com.jiro.service.impl;

import static com.jiro.enums.AccountType.*;

import com.jiro.constants.Constants;
import com.jiro.dao.AccountDao;
import com.jiro.enums.AccountType;
import com.jiro.model.Account;
import com.jiro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dev-pc on 5/30/16.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean canMakeBet(Account player, int betAmount) {
        return player.getTotalChips() >= betAmount;
    }

    @Override
    public void deductChips(Account player, int chipAmount) {
        if (chipAmount > 0)
            if (canMakeBet(player, chipAmount)) {
                player.setTotalChips(player.getTotalChips() - chipAmount);
            }
    }

    @Override
    public void increaseChips(Account player, int chipAmount) {
        if (chipAmount > 0) {
            player.setTotalChips(player.getTotalChips() + chipAmount);
            accountDao.save(player);
        }
    }

    @Override
    public Account createNewPlayer(String username, String password, Integer initialChips) {
        Account player = createNewAccount(username, password, PLAYER);
        if (initialChips != null && initialChips > 0)
            player.setTotalChips(initialChips);
        else
            player.setTotalChips(Constants.INITIAL_CHIP_AMOUNT);

        accountDao.save(player);

        return player;
    }

    @Override
    public Account createNewDealer(String username, String password) {
        return createNewAccount(username, password, DEALER);
    }

    private Account createNewAccount(String username, String password, AccountType accountType) {
        Account account = new Account(username, password);
        switch (accountType) {
            case DEALER:
                account.setDealer(true);
                break;
            case ADMIN:
                account.setAdmin(true);
                break;
            default:
                account.setPlayer(true);
        }

        accountDao.save(account);

        return account;
    }

    @Override
    public Account findById(long accountId) {
        return accountDao.findOne(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.save(account);
    }
}
