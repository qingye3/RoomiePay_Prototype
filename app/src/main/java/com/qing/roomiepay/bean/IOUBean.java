package com.qing.roomiepay.bean;

/**
 * Created by Qing on 12/23/2014.
 */
public class IOUBean {
    private String borrower;
    private double amount;

    public IOUBean(String borrower, double amount) {
        this.borrower = borrower;
        this.amount = amount;
    }

    public String getBorrower() {
        return borrower;
    }

    public double getAmount() {
        return amount;
    }
}
