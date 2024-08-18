package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data

public class
Item {
    private Product product;
    private BigDecimal price;
    private String cartId;
    private int quantity;
}
