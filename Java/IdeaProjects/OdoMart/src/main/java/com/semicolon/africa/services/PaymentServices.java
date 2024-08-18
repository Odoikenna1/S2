package com.semicolon.africa.services;


import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.data.domain.Payment;
import com.semicolon.africa.dtos.request.PaymentRequest;
import com.semicolon.africa.dtos.response.PaymentProcessResponse;

public interface PaymentServices {
    public PaymentProcessResponse processPayment(PaymentRequest paymentRequest);
}
