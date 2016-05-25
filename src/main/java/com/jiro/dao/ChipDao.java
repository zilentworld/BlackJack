package com.jiro.dao;

import com.jiro.model.Chip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChipDao extends CrudRepository<Chip, Long> {

    Chip findByChipDesc(String chipDesc);

    Chip findByChipAmount(int chipAmount);

//    public Chip getById(long chipId) {
//        return (Chip) super.get(Chip.class, chipId);
//    }
//
//    public Chip getByChipDesc(String chipDesc) {
//        return (Chip) getCurrentSession()
//                .createCriteria(Chip.class)
//                .add(Restrictions.eq("chipDesc", chipDesc))
//                .uniqueResult();
//    }
//
//    public Chip getByChipAmount(int chipAmount) {
//        return (Chip) getCurrentSession()
//                .createCriteria(Chip.class)
//                .add(Restrictions.eq("chipAmount", chipAmount))
//                .uniqueResult();
//    }
//
//    public List<Chip> getList() {
//        return (List<Chip>) super.getList(Chip.class);
//    }
}
