package com.eteration.simplebanking.model;

import javax.persistence.Entity;

@Entity
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {

    private String operatorName;
    private String phoneNumber;

    public PhoneBillPaymentTransaction() {

    }

    public PhoneBillPaymentTransaction(String operatorName, String phoneNumber, double transaction) {

        super(transaction);
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
        this.type = "WithdrawalTransaction";
        this.amount = transaction;

    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
