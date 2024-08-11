package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class ShoppingCart {
    @Id
    private String id;
    private String userId;
    private List<Item> items = new ArrayList<>();
}
