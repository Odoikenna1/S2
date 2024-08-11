package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class IncreaseItemQuantityRequest {
    private String userId;
    private Item item;
    private String productId;
}
