package com.jiro.dao;

import com.jiro.model.RoundPlayerCardHand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dev-pc on 5/30/16.
 */
@Transactional
public interface RoundPlayerCardHandDao extends JpaRepository<RoundPlayerCardHand, Long> {

//    @Query("select rp from RoundPlayerCardHand rp")
//    List<RoundPlayerCardHand> findBetRecord(@Param("idArea") Long accountId);

}
