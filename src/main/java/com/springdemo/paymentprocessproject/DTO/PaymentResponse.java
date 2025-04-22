package com.springdemo.paymentprocessproject.DTO;

public class PaymentResponse {
    private Long paymentID;
    private double paymentAmount;
    private String paymentCurrency;

    public Long getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }
    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public String getPaymentCurrency() {
        return paymentCurrency;
    }
    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }
}
