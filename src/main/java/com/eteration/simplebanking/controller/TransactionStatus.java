package com.eteration.simplebanking.controller;


// This class is a place holder you can change the complete implementation

public class TransactionStatus {

    public final static String status = "OK";
    public String approvalCode;

    public String getStatus() {
        return status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
