package com.semicolon.africa.data.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Wallet {
    @Id
    private String id;
    private String userId;
    private BigDecimal balance;
}
