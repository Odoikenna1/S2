package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class InitializeProductRequest {
    private String name;
    private BigDecimal price;
}
