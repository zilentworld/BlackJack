package com.jiro.dao;

import com.jiro.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/30/16.
 */
@Transactional
public interface RoomDao extends CrudRepository<Room, Long> {

}
