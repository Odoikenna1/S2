package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddToCartResponse {
    private String message;
    private int itemListSize;
    private BigDecimal cartSubTotal;
}
