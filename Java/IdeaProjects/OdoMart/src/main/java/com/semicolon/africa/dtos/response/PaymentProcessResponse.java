package com.semicolon.africa.dtos.response;


import com.semicolon.africa.data.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentProcessResponse {
    private String orderId;
    private OrderStatus orderStatus;
}
