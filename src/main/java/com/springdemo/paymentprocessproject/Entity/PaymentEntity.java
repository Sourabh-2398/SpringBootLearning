package com.springdemo.paymentprocessproject.Entity;

public class PaymentEntity {
    private long id;
    private double paymentAmount;
    private String Currency;
    private String userEmail;

    public long getId() {
        return id;
    }

    public void setId(long paymentId) {
        this.id = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double amount) {
        this.paymentAmount = amount;
    }

    public String getPaymentCurrency() {
        return Currency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.Currency = paymentCurrency;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
