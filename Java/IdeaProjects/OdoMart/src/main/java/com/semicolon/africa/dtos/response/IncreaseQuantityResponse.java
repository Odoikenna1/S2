package com.semicolon.africa.dtos.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncreaseQuantityResponse {
    private String cartId;
    private int quantity;
}
