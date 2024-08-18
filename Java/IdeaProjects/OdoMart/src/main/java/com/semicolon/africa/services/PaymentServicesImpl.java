package com.semicolon.africa.services;

import com.semicolon.africa.Exceptions.OrderNotFoundException;
import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.data.domain.OrderStatus;
import com.semicolon.africa.dtos.request.PaymentRequest;
import com.semicolon.africa.dtos.response.PaymentProcessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service @RequiredArgsConstructor
public class PaymentServicesImpl implements PaymentServices{

    private final OrderServices orderServices;

    @Override
    public PaymentProcessResponse processPayment(PaymentRequest paymentRequest) {
        PaymentProcessResponse paymentProcessResponse =new PaymentProcessResponse();
        Order order= paymentRequest.getOrder();
        BigDecimal amountDue = order.getSubTotal();

        if(paymentRequest.getAmountToBePaid().compareTo(amountDue) >= 0){
            paymentProcessResponse.setOrderStatus(OrderStatus.PAID);
            return paymentProcessResponse;
        }
        throw new OrderNotFoundException("No order to process.");
    }

}
