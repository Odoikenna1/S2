package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReduceItemQuantityRequest {
    private String userId;
    private Item item;
    private String productId;
}
