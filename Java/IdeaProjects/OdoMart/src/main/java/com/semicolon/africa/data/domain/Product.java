package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection="products")
public class Product {
    @Id
    private String id;
    private String sellerId;
    private String name;
    private Category category;
    private BigDecimal price;
    private int stock;
}
