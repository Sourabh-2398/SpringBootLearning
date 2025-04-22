package com.springdemo.paymentprocessproject.Repository;

import com.springdemo.paymentprocessproject.DTO.PaymentRequest;
import com.springdemo.paymentprocessproject.Entity.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public PaymentEntity getPaymentByID(PaymentRequest request) {
        // Simulate a database lookup
        return executeQuery(request);
    }

    private PaymentEntity executeQuery(PaymentRequest request) {
        // Simulate a database query
        PaymentEntity paymentModel = new PaymentEntity();
        paymentModel.setId(request.getPaymentId());
        paymentModel.setPaymentAmount(200.0);
        paymentModel.setPaymentCurrency("USAD");
        return paymentModel;
    }
}
