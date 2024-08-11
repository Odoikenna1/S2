package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.data.domain.OrderStatus;
import com.semicolon.africa.data.domain.PaymentMethod;
import com.semicolon.africa.data.domain.PaymentMethod;
import lombok.Data;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class CheckOutRequest {
    private String Id;
    private String userId;
    private BigDecimal subTotal;
    private String billingAddress;
    private PaymentMethod paymentMethod;
    private List<Item> items = new ArrayList<>();
    private OrderStatus status;
}
