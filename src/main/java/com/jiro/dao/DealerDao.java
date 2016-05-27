package com.jiro.dao;

import com.jiro.model.Dealer;
import com.jiro.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/26/16.
 */
@Transactional
public interface DealerDao extends CrudRepository<Dealer, Long> {

    Dealer findByUsername(String username);

    Dealer findByPassword(String password);

}
