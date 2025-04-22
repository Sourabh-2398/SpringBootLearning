package com.springdemo.paymentprocessproject.Service;

import com.springdemo.paymentprocessproject.DTO.PaymentRequest;
import com.springdemo.paymentprocessproject.DTO.PaymentResponse;
import com.springdemo.paymentprocessproject.Entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springdemo.paymentprocessproject.Repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    // Logic to process the payment request and fetch payment details
    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {

        // For example, you might call a repository method to get payment details from the database
        PaymentEntity paymentModel = paymentRepository.getPaymentByID(internalRequestObj);
        // Set the response properties based on the fetched data
        return mapModelToResponseDTO(paymentModel);
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentID(paymentEntity.getId());
        paymentResponse.setPaymentAmount(paymentEntity.getPaymentAmount());
        paymentResponse.setPaymentCurrency(paymentEntity.getPaymentCurrency());
        return paymentResponse;
    }
}
