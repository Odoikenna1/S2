package com.semicolon.africa.dtos.responses;

import lombok.Data;

@Data
public class CreateTransactionHistoryResponse {
    private String id;
    private String userId;
    private String description;
    private String time;
}
