package com.semicolon.africa.dtos.request;

import lombok.Data;

@Data
public class UpdateCartRequest {
    private String userId;
    private String productName;
}
