package com.jiro.dao;

import com.jiro.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/26/16.
 */
@Transactional
public interface AccountDao extends CrudRepository<Account, Long> {

    Account findByUsername(String username);

    Account findByPassword(String password);

}
