package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.data.domain.OrderStatus;
import com.semicolon.africa.data.domain.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CheckOutResponse {
    private String Id;
    private BigDecimal subTotal;
    private List<Item> items = new ArrayList<>();
    private OrderStatus status;
    private Order order;
}
