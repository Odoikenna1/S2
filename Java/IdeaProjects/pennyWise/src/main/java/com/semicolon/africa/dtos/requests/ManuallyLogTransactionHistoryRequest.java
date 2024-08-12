package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@Setter
public class ManuallyLogTransactionHistoryRequest {
    private String userId;
    private String description;
    private BigDecimal amountSpent;
    private String dateOfTransaction;
    private Month month;
    private String timeOfTransaction;
    private LocalDateTime loggedAt = LocalDateTime.now();
}
