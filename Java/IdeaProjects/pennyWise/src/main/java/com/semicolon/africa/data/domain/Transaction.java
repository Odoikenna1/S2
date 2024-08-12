package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data

public class Transaction {
    @Id
    private String transactionId;
    private TransactionType transactionType;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private String transactionAmount;
}
