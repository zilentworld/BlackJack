package com.jiro.service;

import com.jiro.model.Chip;

import java.util.List;

/**
 * Created by dev-pc on 5/25/16.
 */
public interface ChipService {

    Chip getById(long chipId);

    Chip getByChipAmount(int chipAmount);

    Chip getByChipDesc(String chipDesc);

    List<Chip> getList();

}
