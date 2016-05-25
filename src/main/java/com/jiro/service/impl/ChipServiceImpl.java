package com.jiro.service.impl;

import com.jiro.dao.ChipDao;
import com.jiro.model.Chip;
import com.jiro.service.ChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dev-pc on 5/25/16.
 */
@Service
public class ChipServiceImpl implements ChipService {

    @Autowired
    private ChipDao chipDao;

    @Override
    public Chip getById(long chipId) {
//        return chipDao.getById(chipId);
        return null;
    }

    @Override
    public Chip getByChipAmount(int chipAmount) {
//        return chipDao.getByChipAmount(chipAmount);
        return null;
    }

    @Override
    public Chip getByChipDesc(String chipDesc) {
//        return chipDao.getByChipDesc(chipDesc);
        return null;
    }

    @Override
    public List<Chip> getList() {
//        return chipDao.getList();
        return null;
    }
}
