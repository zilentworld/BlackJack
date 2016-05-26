package com.jiro.dao;

import com.jiro.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/26/16.
 */
@Transactional
public interface PlayerDao extends CrudRepository<Player, Long> {

    Player findByUsername(String username);

    Player findByPassword(String password);

}
