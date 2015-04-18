package com.qing.roomiepay.bean;

/**
 * Created by Qing on 12/30/2014.
 * Bean to store data. Only getters are allowed
 */
public class ExpenditureBean extends AmountBean {
    private final String purpose;

    public ExpenditureBean(String purpose, double amount) {
        super(amount);
        this.purpose = purpose;
    }

    @Override
    public String toText() {
        return "$" + String.valueOf(getAmount()) + " for " + purpose;
    }
}
