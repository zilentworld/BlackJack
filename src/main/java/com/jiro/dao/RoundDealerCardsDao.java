package com.jiro.dao;

import com.jiro.model.RoundDealerCards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dev-pc on 5/30/16.
 */
@Transactional
public interface RoundDealerCardsDao extends CrudRepository<RoundDealerCards, Long> {
}
