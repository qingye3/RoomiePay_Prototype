package com.qing.roomiepay.bean;

/**
 * Created by Qing on 12/23/2014.
 * Bean to store data. Only getters are allowed.
 */
public class IOUBean extends AmountBean {
    private final String borrower;

    public IOUBean(String borrower, double amount) {
        super(amount);
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    @Override
    public String toText() {
        return "$" + String.valueOf(getAmount()) + " owed by " + borrower;
    }
}
