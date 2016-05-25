package com.jiro.dao;

import com.jiro.model.Chip;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChipDao extends GenericDao {

    public Chip getById(long chipId) {
        return (Chip) super.get(Chip.class, chipId);
    }

    public Chip getByChipDesc(String chipDesc) {
        return (Chip) getCurrentSession()
                .createCriteria(Chip.class)
                .add(Restrictions.eq("chipDesc", chipDesc))
                .uniqueResult();
    }

    public Chip getByChipAmount(int chipAmount) {
        return (Chip) getCurrentSession()
                .createCriteria(Chip.class)
                .add(Restrictions.eq("chipAmount", chipAmount))
                .uniqueResult();
    }

    public List<Chip> getList() {
        return (List<Chip>) super.getList(Chip.class);
    }
}
