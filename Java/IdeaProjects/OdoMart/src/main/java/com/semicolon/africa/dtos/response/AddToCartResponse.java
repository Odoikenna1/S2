package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartResponse {
    private String message;
    private int itemListSize;
}
