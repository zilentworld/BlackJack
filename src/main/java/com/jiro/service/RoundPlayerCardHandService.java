package com.jiro.service;

import com.jiro.model.RoundPlayerCardHand;

/**
 * Created by dev-pc on 5/31/16.
 */
public interface RoundPlayerCardHandService {

    void saveRoundPlayerCardHand(RoundPlayerCardHand roundPlayerCardHand);

    RoundPlayerCardHand findById(long roundPlayerCardHandId);

    void playDouble(long roundPlayerCardHandId);

}
