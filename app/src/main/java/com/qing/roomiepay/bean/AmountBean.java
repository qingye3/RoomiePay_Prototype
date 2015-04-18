package com.qing.roomiepay.bean;

/**
 * Created by Qing on 12/30/2014.
 * Bean to store data. Only getters are allowed
 */
public abstract class AmountBean {
    private final double amount;

    AmountBean(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract String toText();
}
