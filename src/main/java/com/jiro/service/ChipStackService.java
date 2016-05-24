package com.jiro.service;

import com.jiro.model.Chip;
import com.jiro.model.PlayerChipStack;

public interface ChipStackService {

    void exchangeChips(PlayerChipStack playerChipStack, Chip fromChip, Chip toChip, int numberToExchange);

    void convertToHighestChips(PlayerChipStack playerChipStack, int amount);
}
