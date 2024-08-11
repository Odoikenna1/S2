package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private int stock;
}
