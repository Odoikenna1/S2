package com.semicolon.africa.data.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Data @Document(collection="my_expense_history")
public class Expense {
    private String id;
    private String userId;
    private String description;
    @Setter(AccessLevel.NONE)
    private TransactionType type = TransactionType.DEBIT;
    private Month month;
    private BigDecimal amountSpent;
    private String dateOfTransaction;
    private String timeOfTransaction;
    private LocalDateTime loggedtAt;
}
