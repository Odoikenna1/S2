package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFoundResponse {
    private Product product;
}
