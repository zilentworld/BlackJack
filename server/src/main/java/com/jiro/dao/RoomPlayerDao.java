package com.jiro.dao;

import com.jiro.model.RoomPlayer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/30/16.
 */
@Transactional
public interface RoomPlayerDao extends CrudRepository<RoomPlayer, Long> {
}
