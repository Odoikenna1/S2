package com.semicolon.africa.data.domain;

import com.semicolon.africa.data.models.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection="orders")
public class Order {
    @Id
    private String Id;
    private String userId;
    private BigDecimal subTotal;
    private String billingAddress;
    private String shippingAddress;
    private PaymentMethod paymentMethod;
    private LocalDateTime orderCreationDate = LocalDateTime.now();
    private List<Item> items = new ArrayList<>();
    private OrderStatus status;
}
