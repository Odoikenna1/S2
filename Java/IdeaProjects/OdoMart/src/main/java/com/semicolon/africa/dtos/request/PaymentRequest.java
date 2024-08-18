package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Order;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentRequest {
    private String userId;
    private BigDecimal amountToBePaid;
    private Order order;
}
