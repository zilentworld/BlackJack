package com.jiro.enums;

/**
 * Created by dev-pc on 5/23/16.
 */
public enum Chip {
    ONE("one", 1),
    FIVE("five", 5),
    TEN("ten", 10),
    TWENTY_FIVE("twenty_five", 25),
    FIFTY("fifty", 50),
    HUNDRED("hundred", 100),
    FIVE_HUNDRED("five_hundred", 500),
    THOUSAND("thousand", 1000);

    private int chipValue;
    private String chipDesc;

    Chip(String chipDesc, int chipValue) {
        this.chipValue = chipValue;
        this.chipDesc = chipDesc;
    }

    public int getChipValue() {
        return chipValue;
    }

    public void setChipValue(int chipValue) {
        this.chipValue = chipValue;
    }

    public String getChipDesc() {
        return chipDesc;
    }

    public void setChipDesc(String chipDesc) {
        this.chipDesc = chipDesc;
    }
}
