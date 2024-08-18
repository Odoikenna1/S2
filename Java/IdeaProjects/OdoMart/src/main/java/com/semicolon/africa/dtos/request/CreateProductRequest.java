package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CreateProductRequest {
    private String name;
    private Category category;
    private String sellerId;
    private BigDecimal price;
    private int stock;
}
