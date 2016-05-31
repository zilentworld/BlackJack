package com.jiro.dao;

import com.jiro.model.GameDeck;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dev-pc on 5/31/16.
 */
public interface GameDeckDao extends CrudRepository<GameDeck, Long> {
}
