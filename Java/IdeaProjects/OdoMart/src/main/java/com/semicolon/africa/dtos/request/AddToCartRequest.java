package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import com.semicolon.africa.data.domain.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AddToCartRequest {
    private Item item;
    private String userId;
}
