package com.semicolon.africa.data.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Document(collection="category")
public class ProductCategory {
    @Id
    private String id;
    private String productCategory;
    private List<Product> products = new ArrayList<>();
}
