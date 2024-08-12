package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TransactionHistory {
    @Id
    private String id;
    private List<Transaction> transactions;
    private LocalDateTime loggedAt = LocalDateTime.now();
}
