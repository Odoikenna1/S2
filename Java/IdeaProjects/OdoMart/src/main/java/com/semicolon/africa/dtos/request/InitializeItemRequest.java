package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class InitializeItemRequest {
    private Product product;
    private BigDecimal price;
    private String cartId;
    private int quantity;
}
