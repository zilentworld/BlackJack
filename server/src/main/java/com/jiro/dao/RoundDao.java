package com.jiro.dao;

import com.jiro.model.Round;
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
public interface RoundDao extends JpaRepository<Round, Long> {
//
//    @Query(value = "select r from Round r where r.dealer = :dealerId")
//    List<Round> findByDealerId(@Param("dealerId") long dealerId);

    List<Round> findByDealerId(long dealerId);

}
