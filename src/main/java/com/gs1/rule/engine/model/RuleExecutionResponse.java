package com.gs1.rule.engine.model;

import java.util.ArrayList;
import java.util.List;

public class RuleExecutionResponse {

    private PaymentTransactionDTO paymentTransaction;
    private Integer numberOfAppliedRules;
    private List<String> appliedRules = new ArrayList<>();

    public RuleExecutionResponse(PaymentTransactionDTO paymentTransaction, Integer numberOfAppliedRules, List<String> appliedRules) {
        this.paymentTransaction = paymentTransaction;
        this.numberOfAppliedRules = numberOfAppliedRules;
        this.appliedRules = appliedRules;
    }

    public PaymentTransactionDTO getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(PaymentTransactionDTO paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public List<String> getAppliedRules() {
        return appliedRules;
    }

    public void setAppliedRules(List<String> appliedRules) {
        this.appliedRules = appliedRules;
    }

    public Integer getNumberOfAppliedRules() {
        return numberOfAppliedRules;
    }

    public void setNumberOfAppliedRules(Integer numberOfAppliedRules) {
        this.numberOfAppliedRules = numberOfAppliedRules;
    }
}
